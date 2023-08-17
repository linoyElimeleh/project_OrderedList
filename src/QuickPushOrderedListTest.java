import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class QuickPushOrderedListTest {

    @Test
    public void testPopIntegerComparator() {
        Comparator<Integer> ascendingComparator = Integer::compareTo;
        QuickPushOrderedList<Integer> orderedList = new QuickPushOrderedList<>(ascendingComparator);

        orderedList.push(5);
        orderedList.push(2);
        orderedList.push(8);

        assertEquals(Integer.valueOf(2), orderedList.pop());
        assertEquals(Integer.valueOf(5), orderedList.pop());
        assertEquals(Integer.valueOf(8), orderedList.pop());
        assertNull(orderedList.pop());
    }


    @Test
    public void testPopStringDescendingComparator() {
        Comparator<String> descendingComparator = (a, b) -> b.compareTo(a);
        QuickPushOrderedList<String> orderedList = new QuickPushOrderedList<>(descendingComparator);

        orderedList.push("cherry");
        orderedList.push("banana");
        orderedList.push("apple");

        assertEquals("cherry", orderedList.pop());
        assertEquals("banana", orderedList.pop());
        assertEquals("apple", orderedList.pop());
        assertNull(orderedList.pop());
    }
    @Test
    public void testPopStringAscendingComparator() {
        Comparator<String> ascendingComparator = (a, b) -> a.compareTo(b);
        QuickPushOrderedList<String> orderedList = new QuickPushOrderedList<>(ascendingComparator);

        orderedList.push("cherry");
        orderedList.push("banana");
        orderedList.push("apple");

        assertEquals("apple", orderedList.pop());
        assertEquals("banana", orderedList.pop());
        assertEquals("cherry", orderedList.pop());
        assertNull(orderedList.pop());
    }


    @Test
    public void testPopCustomObjectComparator() {
        Comparator<Person> ageComparator = Comparator.comparingInt(Person::getAge);
        QuickPushOrderedList<Person> orderedList = new QuickPushOrderedList<>(ageComparator);

        var alice= new Person("Alice", 30);
        var bob= new Person("Bob", 25);
        var charlie= new Person("Charlie", 40);

        orderedList.push(alice);
        orderedList.push(bob);
        orderedList.push(charlie);

        assertEquals(bob, orderedList.pop());
        assertEquals(alice, orderedList.pop());
        assertEquals(charlie, orderedList.pop());
        assertNull(orderedList.pop());
    }

    private static class Person {
        private final String name;
        private final int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }
}
