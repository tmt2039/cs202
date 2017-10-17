public class LLNode <E> {
    private E element;
    LLNode pointer;

    public LLNode(E element) {
        this.element = element;
        this.pointer = null;
    }

    public LLNode(E element, LLNode pointer) {
        this.element = element;
        this.pointer = pointer;
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public LLNode getPointer() {
        return pointer;
    }

    public void setPointer(LLNode pointer) {
        this.pointer = pointer;
    }
}