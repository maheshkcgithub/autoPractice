package com.learningpath.basics;

public class Basics02_ControlFlow {

	public static void main(String[] args) {
		ifElseExample(85);
		ifElseExample(40);

		System.out.println("--- switch ---");
		dayNameExample(3);

		System.out.println("--- for loop ---");
		for (int i = 1; i <= 5; i++) {
			System.out.println("Count: " + i);
		}

		System.out.println("--- while loop ---");
		int countdown = 3;
		while (countdown > 0) {
			System.out.println("T-minus " + countdown);
			countdown--;
		}

		System.out.println("--- enhanced for loop ---");
		int[] scores = { 70, 85, 90, 55, 100 };
		int total = 0;
		for (int score : scores) {
			total += score;
		}
		System.out.println("Average score: " + (total / scores.length));
	}

	private static void ifElseExample(int score) {
		if (score >= 90) {
			System.out.println(score + " -> Grade A");
		} else if (score >= 70) {
			System.out.println(score + " -> Grade B");
		} else if (score >= 50) {
			System.out.println(score + " -> Grade C");
		} else {
			System.out.println(score + " -> Fail");
		}
	}

	private static void dayNameExample(int day) {
		String name = switch (day) {
			case 1 -> "Monday";
			case 2 -> "Tuesday";
			case 3 -> "Wednesday";
			case 4 -> "Thursday";
			case 5 -> "Friday";
			case 6, 7 -> "Weekend";
			default -> "Unknown";
		};
		System.out.println("Day " + day + " is " + name);
	}

	// TODO 1: Write a method `isPrime(int n)` and test it with a for loop over
	//         numbers 2 to 30, printing each prime found.
	// TODO 2: Rewrite the `scores` average loop to also print the highest
	//         score, without using any library helper methods (just track it
	//         yourself in the loop).
	// TODO 3: Add a `do-while` loop that keeps asking (simulate with a fixed
	//         array of guesses) until it "guesses" a target number.
}
