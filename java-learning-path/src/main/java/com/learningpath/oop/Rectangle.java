package com.learningpath.oop;

public class Rectangle implements Shape {

	private final double width;
	private final double height;

	public Rectangle(double width, double height) {
		if (width <= 0 || height <= 0) {
			throw new IllegalArgumentException("width and height must be positive");
		}
		this.width = width;
		this.height = height;
	}

	@Override
	public double area() {
		return width * height;
	}

	@Override
	public double perimeter() {
		return 2 * (width + height);
	}

	// TODO: Add a `Square` class that extends `Rectangle` and forces
	// width == height via its constructor (this is the "is-a" test for
	// inheritance: a Square is-a Rectangle with an extra constraint).
}
