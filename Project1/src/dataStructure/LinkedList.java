//package dataStructure;
//
// public class LinkedList<E> extends AbstractList<E> {
//	  private Node<E> head, tail;
//	 	 
//	  public LinkedList() {
//	  }
//	 
//	 
//	 public LinkedList(E[] objects) {
//	  super(objects);
//	  }
//	 
//	 
//	  public E getFirst() {
//	  if (size == 0) {
//	  return null;
//	  }
//	 else {
//	  return head.element;
//	  }
//	  }
//	 
//	 
//	  public E getLast() {
//	  if (size == 0) {
//	  return null;
//	  }
//	  else {
//	  return tail.element;
//	  }
//	  }
//
//	 public void addFirst(E e) {}
//	 public void addLast(E e) {}
//	 @Override
//	 public void add(int index, E e) {} 
//	 public E removeFirst() {}
//	
//		 
//	 
//	  public E removeLast() {
//	 
//	  }
//	 
//	  @Override
//	 
//	  public E remove(int index) {
//	 
//	  }
//	 
//	  @Override
//	  public String toString() {
//	  StringBuilder result = new StringBuilder("[");
//	 
//	  Node<E> current = head;
//	  for (int i = 0; i < size; i++) {
//	  result.append(current.element);
//	  current = current.next;
//	  if (current != null) {
//	  result.append(", "); // Separate two elements with a comma
//	  }
//	  else {
//	  result.append("]"); // Insert the closing ] in the string
//	  }
//	  }
//	 
//	  return result.toString();
//	  }
//	 
//	 @Override 
//	  public void clear() {
//	  size = 0;
//	  head = tail = null;
//	  }
//	 
//	  @Override
//	  public boolean contains(E e) {
//	  System.out.println("Implementation left as an exercise");
//	  return true;
//	  }
//	 
//	 @Override 
//	public E get(int index) {
//	 System.out.println("Implementation left as an exercise");
//	 return null;
//	 }
//	
//	 @Override 
//
//	public int indexOf(E e) {
//	 System.out.println("Implementation left as an exercise");
//	 return 0;
//	 }
//	
//	 @Override 
//
//	public int lastIndexOf(E e) {
//	 System.out.println("Implementation left as an exercise");
//	 return 0;
//	 }
//	
//	 @Override 
//	
//	 public E set(int index, E e) {
//	 System.out.println("Implementation left as an exercise");
//	 return null;
//	 }
//	
//	 @Override 
//	 public java.util.Iterator<E> iterator() {
//	 return new LinkedListIterator();
//	 }
//	
//	 private class LinkedListIterator
//	 implements java.util.Iterator<E> {
//	 private Node<E> current = head; 
//	 @Override
//	 public boolean hasNext() {
//	 return (current != null);
//	 }
//	
//	 @Override
//	 public E next() {
//	 E e = current.element;
//	 current = current.next;
//	 return e;
//	 }
//	
//	 @Override
//	 public void remove() {
//	 System.out.println("Implementation left as an exercise");
//	 }
//	 }
//	
//	 // This class is only used in LinkedList, so it is private.
//	 // This class does not need to access any
//	 // instance members of LinkedList, so it is defined static.
//	 private static class Node<E> {
//	 E element;
//	 Node<E> next;
//	
//	 public Node(E element) {
//	 this.element = element;
//	 } }