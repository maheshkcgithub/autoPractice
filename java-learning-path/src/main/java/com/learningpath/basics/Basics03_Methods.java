package com.learningpath.basics;

public class Basics03_Methods {

	public static void main(String[] args) {
		System.out.println("5 + 3 = " + add(5, 3));
		System.out.println("2^10 = " + power(2, 10));
		System.out.println(describe(42));
		System.out.println(describe("hello"));

		int[] numbers = { 4, 2, 9, 1, 7 };
		System.out.println("Max: " + max(numbers));

		// Overloaded methods: same name, different parameter lists
		System.out.println(greet());
		System.out.println(greet("Ada"));
		System.out.println(greet("Ada", "Good morning"));
	}

	// A simple method with two parameters and a return value
	static int add(int a, int b) {
		return a + b;
	}

	// Recursion: a method calling itself
	static long power(int base, int exponent) {
		if (exponent == 0) {
			return 1;
		}
		return base * power(base, exponent - 1);
	}

	// Varargs-free overloads (see below); here's generics-free polymorphism
	// via Object, just to show it exists. Prefer generics/overloads in real code.
	static String describe(Object value) {
		return value.getClass().getSimpleName() + ": " + value;
	}

	static int max(int[] values) {
		int best = values[0];
		for (int v : values) {
			if (v > best) {
				best = v;
			}
		}
		return best;
	}

	// Method overloading: three versions of "greet"
	static String greet() {
		return greet("friend");
	}

	static String greet(String name) {
		return greet(name, "Hello");
	}

	static String greet(String name, String salutation) {
		return salutation + ", " + name + "!";
	}

	// TODO 1: Write a `min(int[] values)` method mirroring `max`.
	// TODO 2: Write a recursive `factorial(int n)` method and print
	//         factorial(0) through factorial(10).
	// TODO 3: Add a fourth overload of `greet` that takes no name but a
	//         custom salutation (`greet(String salutationOnly, boolean isSalutation)`
	//         won't compile as an overload ambiguity — figure out why, and
	//         find a legal way to express it, e.g. by naming the method
	//         differently or changing parameter types).
}
