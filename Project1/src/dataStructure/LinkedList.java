package dataStructure;

public class LinkedList<E> extends AbstractList<E> {

	private Node<E> head, tail;

	public LinkedList() {
	}

	public LinkedList(E[] objects) {
		super(objects);
	}

	public E getFirst() {
		if (size == 0) {
			return null;
		} else {
			return head.element;
		}
	}

	public E getLast() {
		if (size == 0) {
			return null;
		} else {
			return tail.element;
		}
	}

	public void addFirst(E e) {

		Node<E> newNode = new Node<>(e); // Create a new node
		newNode.next = head; // link the new node with the head
		head = newNode; // head points to the new node
		size++; // Increase list size

		if (tail == null) // The new node is the only node in list
			tail = head;

	}

	public void addLast(E e) {
		Node<E> newNode = new Node<>(e); // Create a new node for e

		if (tail == null) {
			head = tail = newNode; // The only node in list
		} else {
			tail.next = newNode; // Link the new node with the last node
			tail = tail.next; // tail now points to the last node
		}

		size++; // Increase size
	}

	 @Override
	public void add(int index, E e) {
		if (index == 0)
			addFirst(e); // Insert first
		else if (index >= size)
			addLast(e); // Insert last
		else { // Insert in the middle
			Node<E> current = head;
			for (int i = 1; i < index; i++)
				current = current.next;
			Node<E> temp = current.next;
			current.next = new Node<E>(e);
			(current.next).next = temp;
			size++;
		}
	}

	public E removeFirst() {
		if (size == 0) {
			return null;
		} else {
			Node<E> temp = head;
			head = head.next;
			size--;
			if (head == null) {
				tail = null;
			}
			return temp.element;
		}
	}

	public E removeLast() {
		if (size == 0) {
			return null;
		} else if (size == 1) {
			Node<E> temp = head;
			head = tail = null;
			size = 0;
			return temp.element;
		} else {
			Node<E> current = head;

			for (int i = 0; i < size - 2; i++) {
				current = current.next;
			}

			Node<E> temp = tail;
			tail = current;
			tail.next = null;
			size--;
			return temp.element;
		}
	}

	@Override

	public E remove(int index) {

		if (index < 0 || index >= size) {
			return null;
		} else if (index == 0) {
			return removeFirst();
		} else if (index == size - 1) {
			return removeLast();
		} else {
			Node<E> previous = head;

			for (int i = 1; i < index; i++) {
				previous = previous.next;
			}

			Node<E> current = previous.next;
			previous.next = current.next;
			size--;
			return current.element;
		}
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder("[");

		Node<E> current = head;
		for (int i = 0; i < size; i++) {
			result.append(current.element);
			current = current.next;
			if (current != null) {
				result.append(", "); // Separate two elements with a comma
			} else {
				result.append("]"); // Insert the closing ] in the string
			}
		}

		return result.toString();
	}

	@Override
	public void clear() {
		size = 0;
		head = tail = null;
	}

	@Override
	public boolean contains(E e) {
		System.out.println("Implementation left as an exercise");
		return true;
	}

	@Override
	public E get(int index) {
		System.out.println("Implementation left as an exercise");
		return null;
	}

	@Override

	public int indexOf(E e) {
		System.out.println("Implementation left as an exercise");
		return 0;
	}

	@Override

	public int lastIndexOf(E e) {
		System.out.println("Implementation left as an exercise");
		return 0;
	}

	@Override

	public E set(int index, E e) {
		System.out.println("Implementation left as an exercise");
		return null;
	}

	@Override
	public java.util.Iterator<E> iterator() {
		return new LinkedListIterator();
	}

	private class LinkedListIterator implements java.util.Iterator<E> {
		private Node<E> current = head;

		@Override
		public boolean hasNext() {
			return (current != null);
		}

		@Override
		public E next() {
			E e = current.element;
			current = current.next;
			return e;
		}

		@Override
		public void remove() {
			System.out.println("Implementation left as an exercise");
		}
	}

	private static class Node<E> {
		E element;
		Node<E> next;

		public Node(E element) {
			this.element = element;
		}
	}
}