import Models.LinkedList;
import Models.Node;

import java.util.Comparator;

public class QuickPushOrderedList<T> implements OrderedList<T> {
    LinkedList<T> listOfElements = new LinkedList<T>();
    final private Comparator<T> valueComparator;
    private final Object lock = new Object();

    public QuickPushOrderedList(Comparator<T> valueComparator) {
        this.valueComparator = valueComparator;
    }

    @Override
    public T pop() {
        synchronized (lock) {
            Node<T> node = listOfElements.popWithOrder(valueComparator);
            return (node != null) ? node.getValue() : null;
        }
    }

    @Override
    public void push(T element) {
        synchronized (lock) {
            listOfElements.addFirst(new Node<>(element));
        }
    }
}
