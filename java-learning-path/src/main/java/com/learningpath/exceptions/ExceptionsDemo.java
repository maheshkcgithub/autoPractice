package com.learningpath.exceptions;

public class ExceptionsDemo {

	private double balance = 100.0;

	public static void main(String[] args) {
		ExceptionsDemo demo = new ExceptionsDemo();

		unchecked(); // RuntimeException examples, no `throws` needed

		try {
			demo.withdraw(50);
			demo.withdraw(100); // will fail: balance is now 50
		} catch (InsufficientFundsException e) {
			System.out.println("Withdrawal failed: " + e.getMessage());
		} finally {
			// finally always runs, whether or not an exception happened —
			// use it for cleanup (closing files, releasing locks, etc.)
			System.out.println("Final balance: " + demo.balance);
		}
	}

	private static void unchecked() {
		try {
			int[] numbers = { 1, 2, 3 };
			System.out.println(numbers[5]); // ArrayIndexOutOfBoundsException
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Caught: " + e.getClass().getSimpleName() + " - " + e.getMessage());
		}

		try {
			String text = null;
			System.out.println(text.length()); // NullPointerException
		} catch (NullPointerException e) {
			System.out.println("Caught: " + e.getClass().getSimpleName());
		}

		try {
			int result = 10 / 0; // ArithmeticException
			System.out.println(result);
		} catch (ArithmeticException e) {
			System.out.println("Caught: " + e.getClass().getSimpleName() + " - " + e.getMessage());
		}
	}

	// A checked exception forces callers to handle the failure case —
	// good for recoverable, expected business errors like "not enough money".
	void withdraw(double amount) throws InsufficientFundsException {
		if (amount > balance) {
			throw new InsufficientFundsException(
					"Tried to withdraw " + amount + " but balance is only " + balance);
		}
		balance -= amount;
		System.out.println("Withdrew " + amount + ", balance now " + balance);
	}

	// TODO 1: Add a `deposit(double amount)` method that throws an
	//         `IllegalArgumentException` (unchecked) if amount <= 0, and
	//         call it from main inside a try/catch.
	// TODO 2: Write a method that catches multiple exception types in one
	//         catch block using `catch (ArithmeticException | NullPointerException e)`.
	// TODO 3: Explain in a comment: why is `InsufficientFundsException`
	//         checked but `IllegalArgumentException` unchecked? What's the
	//         general rule for choosing between them in your own code?
}
