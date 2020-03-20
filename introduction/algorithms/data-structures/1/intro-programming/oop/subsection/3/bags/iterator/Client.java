import edu.princeton.cs.algs4.StdOut;
import java.util.Iterator;

public class Client {
    public static void main (String[] args) {
       Bag<Integer> bag = null;
       bag = new Bag<Integer>();
       for (int i = 10; i < 20; i++) {
          bag.add(i);
       }
       StdOut.println(bag.size());
       Iterator<Integer> it = bag.iterator();
       while (it.hasNext()) {
           Integer value = it.next();
           StdOut.println("Item " + value);
       }
       // String Bags
       Bag<Strng> bagS = new Bag<String>();
       bagS.add("How ");
       bagS.add("is ");
       bagS.add("good");
       bagS.add("to study");
       bagS.add("Data Strut and Algorithms");
       StdOut.println(bagS.size());
       for (String s : bagS) {
           StdOut.print(s + " ");
       }
       StdOut.println();
    }
}
