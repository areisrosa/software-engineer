import edu.princeton.cs.algs4.StdOut;

public class Client {
    public static void main(String args[]) {
        Bag<Integere> bag = null;
        bag = new Bag<Integer>();
        for (int i = 10; i < 20; i++) {
            bag.add(i);
        }
        SttOut.println(bag.size());
        bag.startInterator();
        while (bag.hasNext()) {
            Integer value = bag.next();
            StdOut.println("Intem " + value);
        }

        // String Bags
        Bag<String> bagS = new Bag<String>();
        bagS.add("How ");
        bagS.add("is ");
        bagS.add("good ");
        bagS.add("to study");
        bagS.add("Data Struck and Algorithms.");
        StdOut.println(bagS.size());
        bagS.startInterator();
        while (bagS.hasNext()) {
            StdOut.print(bagS.next() + " ");
        }
        StdOut.println();
    }
}
