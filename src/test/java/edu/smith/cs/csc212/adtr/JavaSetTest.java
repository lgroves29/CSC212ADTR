package edu.smith.cs.csc212.adtr;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.smith.cs.csc212.adtr.real.JavaSet;

public class JavaSetTest {
	/* 
	 * some functions to make sets of integers so I can test union,
	 * intersection, etc. without typing them out each time
	 */
	private SetADT<Integer> makeSet1(){
		SetADT<Integer> numbers = new JavaSet<>();
		numbers.insert(1);
		numbers.insert(2);
		numbers.insert(3);
		numbers.insert(4);
		return numbers;
	}
	
	private SetADT<Integer> makeSet2(){
		SetADT<Integer> numbers = new JavaSet<>();
		numbers.insert(4);
		numbers.insert(5);
		numbers.insert(6);
		numbers.insert(7);
		return numbers;
	}
	
	@Test
	public void testEmpty() {
		SetADT<String> empty = new JavaSet<>();
		assertEquals(empty.size(), 0);
	}
	@Test
	public void testOne() {
		//left = expected
		//right = actual
		SetADT<String> one = new JavaSet<>();
		one.insert("A");
		assertEquals(1, one.size());
	}
	@Test
	public void testMultiple() {
		SetADT<String> multiple = new JavaSet<>();
		multiple.insert("A");
		multiple.insert("B");
		multiple.insert("C");
		multiple.insert("C");
		multiple.insert("A");
		assertEquals(3, multiple.size());
	}
	@Test
	public void testInsert() {
		SetADT<String> letters = new JavaSet<>();
		letters.insert("A");
		letters.insert("B");
		assertEquals(true, letters.contains("A"));
		assertEquals(true, letters.contains("B"));
	}
	@Test
	public void testContains() {
		SetADT<String> letters = new JavaSet<>();
		letters.insert("A");
		assertEquals(true, letters.contains("A"));
		assertEquals(false, letters.contains("X"));
	}
	@Test
	public void testRemove() {
		SetADT<String> letters = new JavaSet<>();
		letters.insert("A");
		letters.insert("B");
		letters.remove("A");
		//letters.remove("C");
		assertEquals(false, letters.contains("A"));
	}
	
	@Test
	public void testIntersection() {
		SetADT<Integer> left = makeSet1();
		SetADT<Integer> right = makeSet2();
		SetADT<Integer> intersection = Challenges.intersection(left, right);
		for (int num : intersection) {
			System.out.println(num);
			assertEquals(true, (left.contains(num) && right.contains(num)));
		}	
	}
	
	@Test
	public void testUnion() {
		SetADT<Integer> left = makeSet1();
		SetADT<Integer> right = makeSet2();
		SetADT<Integer> union = Challenges.union(left, right);
		for (int num : left) {
			assertEquals(true, union.contains(num));
		}
		for (int num : right) {
			assertEquals(true, union.contains(num));
		}
	}
	
	
}
