package com.learningpath.capstone.taskmanager;

import java.util.Objects;

/**
 * The model: a plain data-holding class (sometimes called a "POJO").
 */
public class Task {

	private final int id;
	private String description;
	private boolean done;

	public Task(int id, String description) {
		this.id = id;
		this.description = Objects.requireNonNull(description, "description must not be null");
		this.done = false;
	}

	public int getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public boolean isDone() {
		return done;
	}

	public void markDone() {
		this.done = true;
	}

	/**
	 * Serializes this task to a single line for file storage:
	 * "id|done|description". Kept intentionally simple (no CSV/JSON library)
	 * so the whole persistence layer is readable in a few lines.
	 */
	public String toFileLine() {
		return id + "|" + done + "|" + description;
	}

	public static Task fromFileLine(String line) {
		String[] parts = line.split("\\|", 3);
		if (parts.length != 3) {
			throw new IllegalArgumentException("Malformed task line: " + line);
		}
		Task task = new Task(Integer.parseInt(parts[0]), parts[2]);
		if (Boolean.parseBoolean(parts[1])) {
			task.markDone();
		}
		return task;
	}

	@Override
	public String toString() {
		return "[" + (done ? "x" : " ") + "] #" + id + " " + description;
	}
}
