package com.learningpath.capstone.taskmanager;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * The console UI. Run this class's main method for an interactive
 * command-line task manager. Tasks are saved to tasks.txt in the current
 * directory so they persist between runs.
 *
 * Commands: add <description> | done <id> | delete <id> | list | quit
 */
public class TaskManagerApp {

	private static final Path STORAGE_FILE = Path.of("tasks.txt");

	public static void main(String[] args) {
		TaskManager manager = new TaskManager();
		try {
			manager.loadFromFile(STORAGE_FILE);
		} catch (IOException e) {
			System.out.println("Could not load existing tasks: " + e.getMessage());
		}

		System.out.println("Task Manager — commands: add <text> | done <id> | delete <id> | list | quit");

		try (Scanner scanner = new Scanner(System.in)) {
			boolean running = true;
			while (running) {
				System.out.print("> ");
				if (!scanner.hasNextLine()) {
					break;
				}
				String line = scanner.nextLine().trim();
				if (line.isEmpty()) {
					continue;
				}
				running = handleCommand(manager, line);
			}
		}

		try {
			manager.saveToFile(STORAGE_FILE);
			System.out.println("Saved tasks to " + STORAGE_FILE.toAbsolutePath());
		} catch (IOException e) {
			System.out.println("Could not save tasks: " + e.getMessage());
		}
	}

	/** Returns false when the app should exit. */
	private static boolean handleCommand(TaskManager manager, String line) {
		String[] parts = line.split("\\s+", 2);
		String command = parts[0].toLowerCase();

		switch (command) {
			case "add" -> {
				if (parts.length < 2) {
					System.out.println("Usage: add <description>");
				} else {
					Task task = manager.addTask(parts[1]);
					System.out.println("Added " + task);
				}
			}
			case "done" -> {
				withId(parts, id -> {
					manager.markDone(id);
					System.out.println("Marked #" + id + " done");
				});
			}
			case "delete" -> {
				withId(parts, id -> {
					manager.deleteTask(id);
					System.out.println("Deleted #" + id);
				});
			}
			case "list" -> printTasks(manager.listTasks());
			case "quit", "exit" -> {
				return false;
			}
			default -> System.out.println("Unknown command: " + command);
		}
		return true;
	}

	private static void withId(String[] parts, java.util.function.IntConsumer action) {
		if (parts.length < 2) {
			System.out.println("Usage: " + parts[0] + " <id>");
			return;
		}
		try {
			int id = Integer.parseInt(parts[1].trim());
			action.accept(id);
		} catch (NumberFormatException e) {
			System.out.println("'" + parts[1] + "' is not a valid task id");
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void printTasks(List<Task> tasks) {
		if (tasks.isEmpty()) {
			System.out.println("(no tasks yet)");
			return;
		}
		tasks.forEach(System.out::println);
	}

	// Next steps once you're comfortable with this class:
	// TODO 1: Add a "help" command that prints the usage text.
	// TODO 2: Add an "edit <id> <new text>" command using
	//         TaskManager.editDescription from its own TODO.
	// TODO 3: Add a "pending" command that only lists unfinished tasks.
	// TODO 4: Bigger stretch goal: swap the flat-file storage for a small
	//         SQLite database using JDBC, keeping the same TaskManager
	//         public API so TaskManagerApp doesn't need to change.
}
