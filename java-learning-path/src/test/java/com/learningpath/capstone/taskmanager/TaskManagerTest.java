package com.learningpath.capstone.taskmanager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * These tests double as executable documentation for TaskManager's
 * behavior. Run them with `mvn test`. If you add a TODO feature to
 * TaskManager, add a test for it here too.
 */
class TaskManagerTest {

	private TaskManager manager;

	@BeforeEach
	void setUp() {
		manager = new TaskManager();
	}

	@Test
	void addTaskAssignsIncrementingIds() {
		Task first = manager.addTask("Write tests");
		Task second = manager.addTask("Run tests");

		assertEquals(1, first.getId());
		assertEquals(2, second.getId());
		assertEquals(2, manager.listTasks().size());
	}

	@Test
	void newTaskStartsNotDone() {
		Task task = manager.addTask("Learn Java");
		assertFalse(task.isDone());
		assertEquals(1, manager.countPending());
	}

	@Test
	void markDoneUpdatesTaskState() {
		Task task = manager.addTask("Learn Java");
		manager.markDone(task.getId());

		assertTrue(manager.findById(task.getId()).orElseThrow().isDone());
		assertEquals(0, manager.countPending());
	}

	@Test
	void markDoneWithUnknownIdThrows() {
		assertThrows(NoSuchElementException.class, () -> manager.markDone(999));
	}

	@Test
	void deleteTaskRemovesIt() {
		Task task = manager.addTask("Temporary");
		manager.deleteTask(task.getId());

		assertTrue(manager.listTasks().isEmpty());
	}

	@Test
	void deleteTaskWithUnknownIdThrows() {
		assertThrows(NoSuchElementException.class, () -> manager.deleteTask(999));
	}

	@Nested
	class Persistence {

		@TempDir
		Path tempDir;

		@Test
		void saveAndLoadRoundTripsTasks() throws IOException {
			manager.addTask("Buy milk");
			Task second = manager.addTask("Walk the dog");
			manager.markDone(second.getId());

			Path file = tempDir.resolve("tasks.txt");
			manager.saveToFile(file);

			TaskManager reloaded = new TaskManager();
			reloaded.loadFromFile(file);

			List<Task> tasks = reloaded.listTasks();
			assertEquals(2, tasks.size());
			assertEquals("Buy milk", tasks.get(0).getDescription());
			assertFalse(tasks.get(0).isDone());
			assertTrue(tasks.get(1).isDone());
		}

		@Test
		void loadFromFileContinuesIdSequence() throws IOException {
			manager.addTask("First");
			manager.addTask("Second");
			Path file = tempDir.resolve("tasks.txt");
			manager.saveToFile(file);

			TaskManager reloaded = new TaskManager();
			reloaded.loadFromFile(file);
			Task third = reloaded.addTask("Third");

			assertEquals(3, third.getId());
		}

		@Test
		void loadFromMissingFileLeavesManagerEmpty() throws IOException {
			Path missing = tempDir.resolve("does-not-exist.txt");

			manager.loadFromFile(missing);

			assertTrue(manager.listTasks().isEmpty());
		}
	}

	// TODO 1: Once you implement TaskManager.editDescription, add a test
	//         `editDescriptionChangesText`.
	// TODO 2: Once you implement findPending()/findDone(), add tests that
	//         mix done and pending tasks and assert the filtered lists.
	// TODO 3: Add a test asserting that `addTask(null)` throws (Task's
	//         constructor already calls Objects.requireNonNull — confirm it
	//         with assertThrows(NullPointerException.class, ...)).
}
