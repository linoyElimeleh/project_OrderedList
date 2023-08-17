import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuickPopOrderedListTest {

    @Test
    public void testIntegerComparator() {
        Comparator<Integer> ascendingComparator = Integer::compareTo;
        QuickPopOrderedList<Integer> orderedList = new QuickPopOrderedList<>(ascendingComparator);

        orderedList.push(5);
        orderedList.push(2);
        orderedList.push(8);

        assertEquals(Integer.valueOf(2), orderedList.pop());
        assertEquals(Integer.valueOf(5), orderedList.pop());
        assertEquals(Integer.valueOf(8), orderedList.pop());
    }

    @Test
    public void testStringComparator() {
        Comparator<String> descendingComparator = (a, b) -> b.compareTo(a);
        QuickPopOrderedList<String> orderedList = new QuickPopOrderedList<>(descendingComparator);

        orderedList.push("apple");
        orderedList.push("banana");
        orderedList.push("cherry");

        assertEquals("cherry", orderedList.pop());
        assertEquals("banana", orderedList.pop());
        assertEquals("apple", orderedList.pop());
    }
    @Test
    public void testCustomObjectComparator() {
        Comparator<Person> ageComparator = Comparator.comparingInt(Person::getAge);
        QuickPopOrderedList<Person> orderedList = new QuickPopOrderedList<>(ageComparator);

        var alice= new Person("Alice", 30);
        var bob= new Person("Bob", 25);
        var charlie= new Person("Charlie", 40);

        orderedList.push(alice);
        orderedList.push(bob);
        orderedList.push(charlie);

        assertEquals(bob, orderedList.pop());
        assertEquals(alice, orderedList.pop());
        assertEquals(charlie, orderedList.pop());
    }

    @Test
    public void testDoubleComparator() {
        Comparator<Double> descendingComparator = (a, b) -> Double.compare(b, a);
        QuickPopOrderedList<Double> orderedList = new QuickPopOrderedList<>(descendingComparator);

        orderedList.push(3.14);
        orderedList.push(1.618);
        orderedList.push(2.718);

        assertEquals(3.14, orderedList.pop(), 0.001);
        assertEquals(2.718, orderedList.pop(), 0.001);
        assertEquals(1.618, orderedList.pop(), 0.001);
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