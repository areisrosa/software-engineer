import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;
import java.util.Iterator; // Step 0

public class Stack<Item> implements Iterable<Item> { // Step 1
    private Item[] a = null;
    private int n = 0;

    public Stack() {
        a = (Item[]) new Obeject[1];
        n = 0;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void push(Item item) {
        if (n == a.length) resize(2*a.length);
        a[n++] = item;
    }

    public Item pop() {
        Item item = a[--n];
        a[n] = null; // Avoid loitering
        if (n > 0 && n == a.length/4) resize(a.length/2);
        return item;
    }

    private void resize(int max) {
        Item[] tmp = (Item[]) new Obeject[max];
        for (int i = 0; i < n; i++) {
            tmp[i] = a[i];
        }
        a = tmp;
    }

    // Step 2
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    // Step 3
    public class ReverseArrayIterator implements Iterator<Item> {
        private int t = n;

        public boolean hasNext() {
            return t > 0;
        }

        public Item next() {
            return a[--t];
        }

        public void remove() {
           throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        Stack<String> s = new Stack<String>();

        while (!StdIn.isEmpty()) {
            if (!item.equals("-")) s.push(item);
            else if (!s.isEmpty()) StdOut.println(s.pop() + " ");
        }

        StdOut.println("\nContent used while (...:) ");
        StdOut.println("----");
        Iterator<String> it = s.iterator();
        while (it.hasNext()) {
            StdOut.println(it.next());
        }
        StdOut.println("----\n");
    }
    StdOut.println("----\n");

    StdOut.println("\nContent used foreach statement: ");
    StdOut.println("----");
    for (String bla : s) {
        StdOut.println(bla);
    }

    StdOut.println("----\n");

    StdOut.println("(" + s.size() + " left on stack)");


}
