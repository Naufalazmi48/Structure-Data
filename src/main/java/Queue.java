public class Queue {
    private final Object[] elements = new Object[5];
    private int front = 0;
    private int rear = 0;

    public Object[] getElements() {
        return elements;
    }

    public void push(Object newElement) throws Exception {
        if (isOverflow()) {
            throw new Exception("Queue Overflow");
        } else {
            if (rear == elements.length) {
                rear = 0;
            }
            elements[rear] = newElement;
            rear++;
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
            throw new Exception("Queue Underflow");
        } else {
            if (front == elements.length) {
                front = 0;
            }
            elements[front] = null;
            front++;
        }
    }
}
