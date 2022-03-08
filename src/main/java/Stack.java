public class Stack {

    public Stack() {}

    public Stack(Object[] initialValue) {
        if (initialValue.length <= elements.length && initialValue.length > 0) {
            elements = initialValue;
            index = elements.length - 1;
        }
    }

    private Object[] elements = new Object[5];
    private int index = 0;

    public Object getElement(int index) {
        return elements[index];
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
            elements[index] = null;
            index--;
        }
    }
}
