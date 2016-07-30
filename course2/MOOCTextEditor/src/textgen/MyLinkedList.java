package textgen;

import java.util.AbstractList;

/**
 * A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E>
 *            The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		this.size = 0;
		this.head = new LLNode<E>(null);
		this.tail = new LLNode<E>(null);

		this.head.next = this.tail;
		this.tail.prev = this.head;
	}

	/**
	 * Appends an element to the end of the list
	 * 
	 * @param element
	 *            The element to add
	 */
	public boolean add(E element) {
		// TODO: Implement this method
		if (element == null) {
			throw new NullPointerException("Check invalid element");
		}

		LLNode<E> newNode = new LLNode<E>(element);
		newNode.next = tail;
		newNode.prev = newNode.next.prev;

		tail.prev.next = newNode;
		newNode.next.prev = newNode;
		size++;
		return true;
	}

	/**
	 * Get the element at position index
	 * 
	 * @throws IndexOutOfBoundsException
	 *             if the index is out of bounds.
	 */
	public E get(int index) {
		// TODO: Implement this method.

		if ((index < 0) || (index > size - 1)) {
			throw new IndexOutOfBoundsException("Check out of bounds");

		}
		LLNode<E> currentNode = head;
		for (int i = 0; i <= index; i++) {
			currentNode = currentNode.next;
		}

		return currentNode.data;

	}

	/**
	 * Add an element to the list at the specified index
	 * 
	 * @param The
	 *            index where the element should be added
	 * @param element
	 *            The element to add
	 */
	public void add(int index, E element) {
		// TODO: Implement this method
		if (element == null) {
			throw new NullPointerException("Check invalid element");
		}
		
		if ((index < 0) || (index > size)) {
			throw new IndexOutOfBoundsException("Check out of bounds");

		}

		LLNode<E> newNode = new LLNode<E>(element);
		LLNode<E> currentNode = head;
		LLNode<E> previousNode = head;

		for (int i = 0; i <= index; i++) {
			previousNode = currentNode;
			currentNode = currentNode.next;
		}

//		System.out.println("\npreviousNode: " + previousNode.data);
//		System.out.println("currentNode: " + currentNode.data);

		newNode.prev = previousNode;
		newNode.next = currentNode;

		newNode.prev.next = newNode;
		newNode.next.prev = newNode;

		size++;
	}

	/** Return the size of the list */
	public int size() {
		// TODO: Implement this method
		return size;
	}

	/**
	 * Remove a node at the specified index and return its data element.
	 * 
	 * @param index
	 *            The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException
	 *             If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) {
		// TODO: Implement this method
		if ((index < 0) || (index >= size)) {
			throw new IndexOutOfBoundsException("Invalid Index");
		}

		LLNode<E> currentNode = head;

		for (int i = 0; i <= index; i++) {
			currentNode = currentNode.next;
		}

		// System.out.println("\ncurrentNode: " + currentNode.data);
		E currentData = currentNode.data;

		currentNode.next.prev = currentNode.prev;
		currentNode.prev.next = currentNode.next;

		currentNode = null;
		size--;
		return currentData;
	}

	/**
	 * Set an index position in the list to a new element
	 * 
	 * @param index
	 *            The index of the element to change
	 * @param element
	 *            The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException
	 *             if the index is out of bounds.
	 */
	public E set(int index, E element) {
		// TODO: Implement this method
		if (element == null) {
			throw new NullPointerException("Check invalid element");
		}
		
		if ((index < 0) || (index >= size)) {
			throw new IndexOutOfBoundsException("Check out of bounds");

		}
		LLNode<E> currentNode = head;
		for (int i = 0; i <= index; i++) {
			currentNode = currentNode.next;
		}
		E currentElement = currentNode.data;
		currentNode.data = element;
		return currentElement;
	}

	public void print() {
		LLNode<E> tempNode = new LLNode<E>();
		tempNode = head;
		System.out.print("Print from head: ");
		for (int i = 0; i <= size + 1; i++) {
			System.out.print(tempNode.data + ", ");
			tempNode = tempNode.next;
		}
	}

	public void printReverse() {
		LLNode<E> tempNode = new LLNode<E>();
		tempNode = tail;
		System.out.print("\nPrint from tail: ");
		for (int i = size; i >= -1; i--) {
			System.out.print(tempNode.data + ", ");
			tempNode = tempNode.prev;
		}
	}

}

class LLNode<E> {
	LLNode<E> prev;
	E data;
	LLNode<E> next;
	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode() {
		this.prev = null;
		this.data = null;
		this.next = null;
	}

	public LLNode(E e) {
		this.prev = null;
		this.data = e;
		this.next = null;
	}
}
