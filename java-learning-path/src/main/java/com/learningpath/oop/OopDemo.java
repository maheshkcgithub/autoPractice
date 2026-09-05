package com.learningpath.oop;

import java.util.List;

public class OopDemo {

	public static void main(String[] args) {
		// Polymorphism: a List<Shape> can hold any Shape implementation, and
		// calling area()/perimeter() always runs the *actual* class's code,
		// chosen at runtime (dynamic dispatch) — not the declared type's.
		List<Shape> shapes = List.of(
				new Circle(3),
				new Rectangle(4, 5),
				new Circle(1.5));

		double totalArea = 0;
		for (Shape shape : shapes) {
			System.out.println(shape.describe());
			totalArea += shape.area();
		}
		System.out.printf("Total area: %.2f%n", totalArea);

		System.out.println("---");

		List<Animal> animals = List.of(new Dog("Rex"), new Cat("Whiskers"));
		for (Animal animal : animals) {
			System.out.println(animal.introduce());
		}
	}

	// TODO 1: Add a `Triangle` class implementing `Shape` (base * height / 2
	//         for area; you'll need three side lengths for perimeter) and
	//         add an instance to the `shapes` list above.
	// TODO 2: Change `totalArea` to instead find the shape with the largest
	//         area and print its `describe()`.
	// TODO 3: Explain in a comment: why can `shapes` be typed `List<Shape>`
	//         holding `Circle` and `Rectangle` objects, but you couldn't
	//         call `.radius` on an element of that list even though some of
	//         them are actually Circles?
}
