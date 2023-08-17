**OrderedList**

**QuickPopOrderedList** is a Java library that provides an implementation of an ordered list with efficient pop operation. The list automatically maintains the order of elements based on a user-defined comparator.

In the same way, **QuickPushOrderedList** is a Java library that provides an implementation of an ordered list with efficient push operation. The list automatically maintains the order of elements based on a user-defined comparator.

*Features*

- Efficient pop or push operations while maintaining element order.
- Customizable ordering using a comparator function.
- Thread-safe implementation using synchronization.


*Getting Started*

Prerequisites

- Java JDK (version 11 or higher)

Installation

1. Clone the repository:

git clone https://github.com/linoyElimeleh/project_OrderedList.git

2. Import the project into your preferred Java IDE.

Usage

1. Create an instance of QuickPopOrderedList by providing a comparator:

```java
Comparator<Integer> ascendingComparator = Integer::compareTo;
QuickPopOrderedList<Integer> orderedList = new QuickPopOrderedList<>(ascendingComparator);
```

2. Push elements into the ordered list:

```java
orderedList.push(5);
orderedList.push(2);
orderedList.push(8);
```

3. Pop elements from the ordered list:

```java
Integer firstElement = orderedList.pop(); // Returns 2
Integer secondElement = orderedList.pop(); // Returns 5
```

*Thread Safety*

This library provides a thread-safe implementation using synchronization. If you require concurrent access to the list from multiple threads, ensure that you handle synchronization properly.

*Contributing*

Contributions are welcome! If you find a bug or want to add a new feature, please submit a pull request.


*Contact*

For questions or support, please contact lino1998y@gmail.com
