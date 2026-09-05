package com.learningpath.basics;

/**
 * Run this class's main method and read the output alongside the code.
 */
public class Basics01_VariablesAndTypes {

	public static void main(String[] args) {
		// Primitive types
		int age = 30;
		double price = 19.99;
		boolean isJavaFun = true;
		char grade = 'A';

		// Reference type
		String name = "Ada";

		System.out.println(name + " is " + age + " years old.");
		System.out.println("Price: $" + price);
		System.out.println("Is Java fun? " + isJavaFun);
		System.out.println("Grade: " + grade);

		// Type widening happens automatically; narrowing needs a cast.
		int wholeNumber = (int) price; // truncates to 19
		System.out.println("Whole number part of price: " + wholeNumber);

		// final = constant, cannot be reassigned
		final double TAX_RATE = 0.08;
		System.out.println("Total with tax: " + (price + price * TAX_RATE));

		// String is immutable: concatenation creates a new String each time
		String greeting = "Hello";
		greeting = greeting + ", " + name + "!";
		System.out.println(greeting);
	}

	// TODO 1: Add a variable for your own name and age, and print a sentence
	//         using them.
	// TODO 2: Declare an `int` and a `long` variable holding the same large
	//         number (e.g. 3_000_000_000). Which one fails to compile, and
	//         why? Fix it.
	// TODO 3: Declare a `float` and assign it 3.14 directly (`float f = 3.14;`).
	//         It won't compile — figure out why from the error message and
	//         fix it with the correct literal suffix.
}
