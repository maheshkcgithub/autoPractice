package com.learningpath.capstone.taskmanager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * The "service" layer: holds the in-memory list of tasks and knows how to
 * load/save them from a file. Keeping this separate from `Task` (the model)
 * and `TaskManagerApp` (the console UI) is a small example of separation of
 * concerns — each class has one job.
 */
public class TaskManager {

	private final List<Task> tasks = new ArrayList<>();
	private int nextId = 1;

	public Task addTask(String description) {
		Task task = new Task(nextId++, description);
		tasks.add(task);
		return task;
	}

	public List<Task> listTasks() {
		return List.copyOf(tasks);
	}

	public void markDone(int id) {
		Task task = findById(id)
				.orElseThrow(() -> new NoSuchElementException("No task with id " + id));
		task.markDone();
	}

	public void deleteTask(int id) {
		boolean removed = tasks.removeIf(t -> t.getId() == id);
		if (!removed) {
			throw new NoSuchElementException("No task with id " + id);
		}
	}

	public Optional<Task> findById(int id) {
		return tasks.stream().filter(t -> t.getId() == id).findFirst();
	}

	public long countPending() {
		return tasks.stream().filter(t -> !t.isDone()).count();
	}

	public void saveToFile(Path file) throws IOException {
		List<String> lines = tasks.stream().map(Task::toFileLine).toList();
		Files.write(file, lines);
	}

	public void loadFromFile(Path file) throws IOException {
		tasks.clear();
		nextId = 1;
		if (!Files.exists(file)) {
			return;
		}
		for (String line : Files.readAllLines(file)) {
			if (line.isBlank()) {
				continue;
			}
			Task task = Task.fromFileLine(line);
			tasks.add(task);
			nextId = Math.max(nextId, task.getId() + 1);
		}
	}

	// TODO 1: Add a `List<Task> findPending()` and `List<Task> findDone()`
	//         using streams + filter, instead of always returning everything.
	// TODO 2: Add an `editDescription(int id, String newDescription)` method.
	// TODO 3: `nextId` resets to 1 on every `loadFromFile` call before being
	//         recomputed from the file — what would go wrong if you forgot
	//         the `nextId = Math.max(...)` line? Try removing it temporarily,
	//         add two tasks, save, reload, and add a third task to see the bug.
}
