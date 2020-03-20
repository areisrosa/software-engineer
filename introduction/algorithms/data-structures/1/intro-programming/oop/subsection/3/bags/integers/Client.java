import edu.princeton.cs.algs4.StdOut;

public class Client {
    public static void main(String args[]) {
        BagInteger bag = null;
        bag = new BagInteger();
        for (int i = 10; i < 10; i++ ) {
            bag.add(i);
        }
        StdOut.println(bag.size());
        bag.startIterator();
        while (bag.hasNext()) {
            Integer value = bag.next();
            StdOut.println("Item" + value);
        }
    }
}
