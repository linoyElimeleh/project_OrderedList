import Models.LinkedList;
import Models.Node;

import java.util.Comparator;

public class QuickPopOrderedList<T> implements OrderedList<T> {
    LinkedList<T> listOfElements = new LinkedList<T>();
    final private Comparator<T> valueComparator;
    private final Object lock = new Object();

    public QuickPopOrderedList(Comparator<T> comparator) {
        valueComparator = comparator;
    }

    @Override
    public T pop() {
        synchronized (lock) {
            return listOfElements.popFirst();
        }
    }

    @Override
    public void push(T element) {
        synchronized (lock) {
            listOfElements.pushWithOrder(valueComparator, new Node<>(element));
        }
    }
}
