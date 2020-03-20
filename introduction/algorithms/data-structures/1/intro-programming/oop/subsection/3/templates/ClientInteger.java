// API a BagInteger
// (see S.W's book Algorithms and Data Structures ou Algorithms I)
// ...

public class ClientInteger {
    public static void main(String[] args) {
        BagInteger bag = new BagInteger();
        for (int i = 10; i < 20 ; i++) {
            bag.add(i);
        }
        StdOut.println(bag.size());
        bag.startInteger();
        while (bag.hasNext()) {
            StdOut.println(bag.next());
        }
    }
}
