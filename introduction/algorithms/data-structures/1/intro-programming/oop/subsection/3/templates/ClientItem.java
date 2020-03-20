// API of a generic bag (Bag<Item>)
// Note: The notation <Item> before of class name define the Item name with a type 
// parameter, a placeholder for a concrete type to be used by the customer.
// Let's Bag<Item> like items bag.
// (know more in the book S.W's - Algorithms and Data Structures ou Algorithms I)
// ...

public class ClientInteger {
    public static void main(String[] args) {
        Bag<String> bagS = new Bag<String>();
        bagS.add("How "); bagS.add("is ");
        bag.add("good ");
        bagS.add("to study");
        bagS.add("Data Structure and Algorithms")
        StdOut.println(bag.size());
        bag.startIterator();
        while (bag.hasNext()) {
            StdOut.println(bag.next());
        }
    }
}
