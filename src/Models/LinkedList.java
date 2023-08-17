package Models;

import java.util.Comparator;

public class LinkedList<T> {
    Integer size;
    Node<T> first;
    Node<T> last;

    public LinkedList() {
        size = 0;
        first = null;
        last = null;
    }
    public void addFirst(Node<T> newNode) {
        if (newNode == null) {
            throw new IllegalArgumentException("Node cannot be null");
        }

        newNode.next = first;
        first = newNode;

        if (last == null) {
            last = newNode;
        }

        increaseSize();
    }

    public T popFirst() {
        if (size == 0) {
            throw new IllegalStateException("List is empty");
        }

        Node<T> removedNode = first;
        first = first.next;
        decreaseSize();

        if (size == 0) {
            last = null;
        }

        return removedNode.getValue();
    }

    public void pushWithOrder(Comparator<T>comparator, Node<T> element) {

        if (element == null) {
            throw new IllegalArgumentException("Node cannot be null");
        }

        Node<T> current = getFirst();
        Node<T> previous = null;

        while (current != null && comparator.compare(element.value, current.value) > 0) {
            previous = current;
            current = current.getNext();
        }

        if (previous == null) {
            element.setNext(first);
            setFirst(element);
        } else {
            previous.setNext(element);
            element.setNext(current);
        }

        if (last == null || comparator.compare(element.getValue(), last.getValue()) < 0) {
            setLast(element);
        }

        increaseSize();
    }

    public Node<T> popWithOrder(Comparator<T> comparator) {
        if (getSize() == 0) {
            return null;
        }

        // Bubble sort to order the elements based on the comparator
        boolean swapped;
        do {
            swapped = false;
            Node<T> current = first;
            Node<T> previous = null;

            while (current != null && current.getNext() != null) {
                Node<T> next = current.getNext();
                if (comparator.compare(current.getValue(), next.getValue()) > 0) {
                    swapped = true;

                    if (previous == null) {
                        first = next;
                    } else {
                        previous.setNext(next);
                    }

                    current.setNext(next.getNext());
                    next.setNext(current);

                    if (current == last) {
                        last = next;
                    }

                    previous = next;
                } else {
                    previous = current;
                    current = current.getNext();
                }
            }
        } while (swapped);

        Node<T> popped = first;
        if (first != null) {
            first = first.getNext();
            if (popped == last) {
                last = null;
            }
            decreaseSize();
        }

        return popped;
    }

    public Integer getSize() {
        return size;
    }

    public void increaseSize() {
        this.size ++;
    }
    public void decreaseSize() {
        this.size--;
    }

    public Node<T> getFirst() {
        return first;
    }

    public void setFirst(Node<T> first) {
        this.first = first;
    }

    public void setLast(Node<T> last) {
        this.last = last;
    }
}
