// API of a iterable generic bag (Bag<Item>)
// Note: The notation <Item> before of class name define the Item name with a type 
// parameter, a placeholder for a concrete type to be used by the customer.
// Let's Bag<Item> like items bag.
// (know more in the book S.W's - Algorithms and Data Structures ou Algorithms I)
// ...

public class ClientLuxe {
    public static void main(String[] args) {
        Bag<String> bagS = new Bag<String>();
        bagS.add("How "); bagS.add("is ");
        bag.add("good ");
        bagS.add("to study");
        bagS.add("Data Structure and Algorithms");
        StdOut.println(bagS.size());
        for (String item: bagS) {
            StdOut.println(item);
        }
        // item is an element of the `bagS` array
        // which is essentially equivalent of 
        // for (Iterator<String>; it = bagS.iterator(); it.hasNext();) {
        //      String item = it.next()
        //      StdOut.println(it.next());
        // }
        // Note: That if you need to use it.remove(); in your loop, or access
        // the actual iterator in some way, you cannot use the for( : )
        // idiom, since the actual Iterator is merely inferred.
        //
        // Also, if the right-hand side of the for (:) idiom is an array
        // rather than an Iterable object, the internal code uses an int
        // index counter and checks against array.length instead. See the
        // Java Language Specification.
        // For Exemple:
        // The construct for each is also valid for arrays. e.g.
        // String[] fruits = new String[] { "Orange", "Apple", "Pear",
        // "Strawberry" };
        // for (String fruit : fruits) {
        //     // fruit is an element of the `fruits` array.
        // }
        // which is essentially equivalent of
        //         //for (int i = 0; i < fruits.length; i++) {
        // String fruit = fruits[i];
        // // fruit is an element of the `fruits` array.
    }
}
