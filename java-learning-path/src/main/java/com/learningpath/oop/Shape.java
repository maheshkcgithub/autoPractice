package com.learningpath.oop;

/**
 * An interface defines a contract: any class that "implements Shape" must
 * provide these methods. It has no state and (here) no implementation.
 */
public interface Shape {
	double area();

	double perimeter();

	// default methods let an interface provide a shared implementation
	// that implementing classes can use as-is or override.
	default String describe() {
		return String.format("%s[area=%.2f, perimeter=%.2f]",
				getClass().getSimpleName(), area(), perimeter());
	}
}
