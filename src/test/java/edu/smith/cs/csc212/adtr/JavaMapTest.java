package edu.smith.cs.csc212.adtr;

import static org.junit.Assert.*;
import org.junit.Test;

import edu.smith.cs.csc212.adtr.real.JavaList;
import edu.smith.cs.csc212.adtr.real.JavaMap;

public class JavaMapTest {
	
	private ListADT<String> makeList(){
		ListADT<String> words = new JavaList<>();
		words.addBack("apple");
		words.addBack("pear");
		words.addBack("banana");
		return words;
	}
	
	// you might want this.
	void assertIntEq(int x, int y) {
		assertEquals(x, y);
	}

	@Test
	public void testEmpty() {
		MapADT<String, String> empty = new JavaMap<>();
		assertEquals(empty.size(), 0);
		//Assert.assert
	}
	@Test
	public void testPut() {
		MapADT<String, String> letters  = new JavaMap<>();
		letters.put("A", "apple");
		letters.put("B", "bananas");
		assertEquals(2, letters.size());
		
		 
	}
	@Test
	public void testUpdate() {
		MapADT<String, String> letters  = new JavaMap<>();
		letters.put("A", "apple");
		letters.put("B", "bananas");
		letters.put("B", "berry");
		assertEquals("berry", letters.get("B"));
	}
	@Test
	public void testGet() {
		MapADT<String, String> letters  = new JavaMap<>();
		letters.put("A", "apple");
		letters.put("B", "banana");
		assertEquals("apple", letters.get("A"));
		assertEquals("banana", letters.get("B"));
	}
	@Test
	public void testSize() {
		testPut();
	}
	
	@Test
	public void testRemove() {
		MapADT<String, String> letters  = new JavaMap<>();
		letters.put("A", "apple");
		letters.put("B", "banana");
		letters.remove("B");
		assertEquals(1, letters.size());
	}
	
	@Test 
	public void testWordCount() {
		ListADT<String> words = makeList();
		MapADT<String, Integer> wordMap = Challenges.wordCount(words);
		for (int i = 0; i < words.size(); i++) {
			assertIntEq(wordMap.get(words.getIndex(i)), i );
		}
	}
}
