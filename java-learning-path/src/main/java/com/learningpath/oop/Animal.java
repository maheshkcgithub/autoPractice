package com.learningpath.oop;

/**
 * An abstract class can hold shared state and shared implementation, but
 * (like an interface) can also declare methods with no body that subclasses
 * must implement. Use abstract classes when subclasses share real state or
 * behavior; use interfaces for a pure contract.
 */
public abstract class Animal {

	private final String name;

	protected Animal(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	// Every subclass must define its own sound.
	public abstract String makeSound();

	// Shared behavior all animals get for free.
	public String introduce() {
		return name + " says " + makeSound();
	}
}
