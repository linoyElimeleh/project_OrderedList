import Models.Node;

import java.util.Comparator;

public class Main{
    public static void main(String[] args) {
        System.out.println("Hello world!");

        // Create a comparator for integers in ascending order
        Comparator<Integer> ascendingComparator = (a, b) -> a.compareTo(b);

        // Create an instance of QuickPopOrderedList
        QuickPopOrderedList<Integer> orderedList = new QuickPopOrderedList<>(ascendingComparator);

        // Push elements into the ordered list
        orderedList.push(5);
        orderedList.push(2);
        orderedList.push(8);

        // Pop elements from the ordered list
        System.out.println(orderedList.pop()); // Should print "2"
        System.out.println(orderedList.pop()); // Should print "5"
        System.out.println(orderedList.pop()); // Should print "8"
    }
}