public class Stack {

    private final Object[] elements = new Object[5];
    private int index = 0;

    public Object[] getElements() {
        return elements;
    }

    public void push(Object newElement) throws Exception {
        if (isOverflow()) {
            throw new Exception("Stack Overflow");
        } else {
            elements[index] = newElement;
            index++;
        }
    }

    private boolean isOverflow() {
        return size() == elements.length;
    }

    public boolean isEmpty() {return size() == 0;}

    public int size() {
        int size = 0;
        for (Object el : elements) {
            if (el != null) {
                size++;
            }
        }
        return size;
    }

    public boolean contains(Object element) {
        for (Object el : elements) {
            if (el != null && el.equals(element)) {
                return true;
            }
        }
        return false;
    }

    public void pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("Stack Underflow");
        } else {
            elements[index - 1] = null;
            index--;
        }
    }
}
