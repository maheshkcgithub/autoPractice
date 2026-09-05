package com.learningpath.oop;

public class Cat extends Animal {

	public Cat(String name) {
		super(name);
	}

	@Override
	public String makeSound() {
		return "Meow!";
	}

	// TODO: Add a `Puppy` class that extends `Dog` and overrides
	// `makeSound()` to return "Yip!" instead of "Woof!". This shows that
	// overriding can happen at any depth in the hierarchy, not just one
	// level below the abstract class.
}
