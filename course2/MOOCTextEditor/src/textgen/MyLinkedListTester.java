/**
 * 
 */
package textgen;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

//https://github.com/jamesguoxin/TextEditor/blob/master/src/textgen/MyLinkedList.java
/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH = 10;

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
		shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++) {
			longerList.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);
	}

	/**
	 * Test if the get method is working correctly.
	 */
	/*
	 * You should not need to add much to this method. We provide it as an
	 * example of a thorough test.
	 */
	@Test
	public void testGet() {
		// test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {

		}

		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));

		try {
			shortList.get(-1);
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {

		}
		try {
			shortList.get(2);
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {

		}
		// test longer list contents
		for (int i = 0; i < LONG_LIST_LENGTH; i++) {
			assertEquals("Check " + i + " element", (Integer) i, longerList.get(i));
		}

		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {

		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {
		}

	}

	/**
	 * Test removing an element from the list. We've included the example from
	 * the concept challenge. You will want to add more tests.
	 */
	@Test
	public void testRemove() {
		int a = list1.remove(0);
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer) 21, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());

		// TODO: Add more tests here
		try {
			shortList.remove(-1);
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {

		}

		try {
			shortList.remove(2);
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {

		}

		// test longer list contents
		for (int i = 0; i < LONG_LIST_LENGTH; i++) {
			assertEquals("Check", (Integer) i, longerList.get(i));
		}

		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {
		}
	}

	/**
	 * Test adding an element into the end of the list, specifically public
	 * boolean add(E element)
	 */
	@Test
	public void testAddEnd() {
		// TODO: implement this test
		try {
			shortList.add(null);
			fail("Check invalid element");
		} catch (NullPointerException e) {

		}
		boolean state = emptyList.add(0);
		assertEquals("AddEnd: check state is correct ", true, state);
		assertEquals("AddEnd: check value is correct", (Integer) 0, emptyList.get(0));
		assertEquals("AddEnd: check size is correct", 1, emptyList.size());
	}

	/** Test the size of the list */
	@Test
	public void testSize() {
		// TODO: implement this test
		assertEquals("Size: empty list ", 0, emptyList.size());
		assertEquals("Size: long list ", 10, longerList.size());
		longerList.add(10);
		assertEquals("Size: long list ", 11, longerList.size());
	}

	/**
	 * Test adding an element into the list at a specified index, specifically:
	 * public void add(int index, E element)
	 */
	@Test
	public void testAddAtIndex() {
		// TODO: implement this test
		try {
			shortList.add(0, null);
			fail("Check invalid element");
		} catch (NullPointerException e) {

		}
		// shortList.print();
		try {
			shortList.add(3, "C");
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {

		}
		try {
			shortList.add(-1, "C");
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {

		}

		shortList.add(2, "C");
		assertEquals("AddAtIndex: check value is correct ", (String) "C", shortList.get(2));
	}

	/** Test setting an element in the list */
	@Test
	public void testSet() {
		// TODO: implement this test
		try {
			shortList.set(0, null);
			fail("Check invalid element");
		} catch (NullPointerException e) {

		}

		try {
			shortList.set(-1, "C");
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {

		}
		
		try {
			longerList.set(10, 11);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		longerList.set(0, 100);
		assertEquals("AddAtIndex: check value is correct ", (Integer)100, longerList.get(0));
		longerList.set(1, 101);
		assertEquals("AddAtIndex: check value is correct ", (Integer)101, longerList.get(1));
		
		shortList.set(1, "Z");
		assertEquals("AddAtIndex: check value is correct ", (String)"Z", shortList.get(1));
	}

	// TODO: Optionally add more test methods.

}