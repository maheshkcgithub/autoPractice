package com.learningpath.fileio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileIoDemo {

	public static void main(String[] args) throws IOException {
		Path file = Path.of("java-learning-path-demo.txt");

		// try-with-resources closes the writer automatically, even if an
		// exception is thrown — no need for a manual finally block.
		List<String> lines = List.of(
				"Line one",
				"Line two",
				"Line three");
		Files.write(file, lines);
		System.out.println("Wrote " + lines.size() + " lines to " + file.toAbsolutePath());

		List<String> readBack = Files.readAllLines(file);
		System.out.println("Read back:");
		readBack.forEach(System.out::println);

		// Appending: open in append mode instead of overwriting
		Files.writeString(file, "Line four (appended)\n",
				java.nio.file.StandardOpenOption.APPEND);
		System.out.println("--- after append ---");
		Files.readAllLines(file).forEach(System.out::println);

		// Clean up the demo file so re-running this class stays repeatable.
		Files.deleteIfExists(file);
		System.out.println("Deleted demo file.");
	}

	// TODO 1: Change this to write to a file in a subdirectory (e.g.
	//         "data/demo.txt") — you'll need to create the directory first
	//         with `Files.createDirectories`.
	// TODO 2: Use a classic `BufferedReader`/`FileWriter` with an explicit
	//         `try (... ) { }` block instead of the `Files` helper methods,
	//         to see what try-with-resources is doing under the hood.
	// TODO 3: Wrap the whole thing in a try/catch for `IOException` instead
	//         of declaring `throws IOException` on main, and print a
	//         friendly error message instead of a stack trace.
}
