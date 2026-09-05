package com.learningpath.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectionsDemo {

	public static void main(String[] args) {
		listExample();
		setExample();
		mapExample();
		streamExample();
	}

	private static void listExample() {
		System.out.println("--- List ---");
		List<String> fruits = new ArrayList<>();
		fruits.add("apple");
		fruits.add("banana");
		fruits.add("cherry");
		fruits.add("apple"); // lists allow duplicates and keep insertion order

		System.out.println("Fruits: " + fruits);
		System.out.println("First fruit: " + fruits.get(0));
		fruits.remove("banana");
		System.out.println("After removing banana: " + fruits);
	}

	private static void setExample() {
		System.out.println("--- Set ---");
		Set<String> uniqueFruits = new HashSet<>();
		uniqueFruits.add("apple");
		uniqueFruits.add("banana");
		uniqueFruits.add("apple"); // duplicate is silently ignored

		System.out.println("Unique fruits (size=" + uniqueFruits.size() + "): " + uniqueFruits);
		System.out.println("Contains banana? " + uniqueFruits.contains("banana"));
	}

	private static void mapExample() {
		System.out.println("--- Map ---");
		Map<String, Integer> stock = new HashMap<>();
		stock.put("apple", 50);
		stock.put("banana", 30);
		stock.put("cherry", 100);

		System.out.println("Stock: " + stock);
		System.out.println("Cherries in stock: " + stock.get("cherry"));

		// getOrDefault avoids null-checking every lookup
		System.out.println("Kiwis in stock: " + stock.getOrDefault("kiwi", 0));

		for (Map.Entry<String, Integer> entry : stock.entrySet()) {
			System.out.println(entry.getKey() + " -> " + entry.getValue());
		}
	}

	private static void streamExample() {
		System.out.println("--- Streams ---");
		List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		List<Integer> evenSquares = numbers.stream()
				.filter(n -> n % 2 == 0)
				.map(n -> n * n)
				.collect(Collectors.toList());
		System.out.println("Even squares: " + evenSquares);

		int sum = numbers.stream().mapToInt(Integer::intValue).sum();
		System.out.println("Sum: " + sum);

		double average = numbers.stream().mapToInt(Integer::intValue).average().orElse(0);
		System.out.println("Average: " + average);

		boolean anyOverFive = numbers.stream().anyMatch(n -> n > 5);
		System.out.println("Any number over 5? " + anyOverFive);
	}

	// TODO 1: In listExample, add code that prints how many times "apple"
	//         appears in `fruits` (hint: Collections.frequency).
	// TODO 2: In mapExample, use `stock.entrySet().stream()` and streams to
	//         print only the fruits with stock > 40, sorted by quantity
	//         descending.
	// TODO 3: In streamExample, use `Collectors.joining(", ")` to turn
	//         `evenSquares` into a single comma-separated String and print it.
	// TODO 4: Explain in a comment: why does `HashSet` not guarantee any
	//         particular iteration order, while `ArrayList` always iterates
	//         in insertion order? (Hint: look up `LinkedHashSet` too.)
}
