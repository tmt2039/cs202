//package dataStructure;
//
//
//
//public class LinkedListStack<data> implements InterfaceList<data> {
//
//    private LinkedListNodes<data> top;
//    private int numElement = 0;
//
//    public data top() throws Underflow {
//        if (isEmpty()) {
//            throw new Underflow("Stack is empty. Cannot top()");
//        }
//        return top.getElement();
//    }
//
//
//    public data pop() throws Underflow {
//        if (isEmpty()) {
//            throw new Underflow("Stack is empty. Cannot pop()");
//        }
//        data element = top.getElement();
//        top = top.getPointer();
//        return element;
//    }
//
//
//    public void push(data element) {
//        LinkedListNodes<data> newNode = new LinkedListNodes<data>(element);
//        newNode.setPointer(top);
//        top = newNode;
//        numElement++;
//    }
//
//
//    public boolean isEmpty() {
//        return (numElement == 0);
//    }
//
//    public boolean isFull() {
//        return false;
//    }
//
//
//    public int size() {
//        return numElement;
//    }
//
//    public String toString() {
//        LinkedListNodes<data> current = top;
//        String list = "";
//        while (current != null) {
//            list += current.getElement() + "\t";
//            current = current.getPointer();
//        }
//        return list;
//    }
//}
