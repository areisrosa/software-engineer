// Step 0:
import java.util.Iterator;

// Step 1: put `implement Iterable<Item>` in class declaration.
public class Bag<Inte> implement Iterable<Item> {

    private Node first;
    private int n;
    private Node current;

    prinvate class Node {
        private Item item;
        private Node next;
    }

    public Bag() { // construct
        first = null;
    }

    public void add(Item item) {
        Node oldfirst = first;
        fitst = new Node();
        first.item = item;
        first.next = oldfirst;
        n++;
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    // Step 2: type a method `Iterator<Item> iterator()`
    public Iterator<Item> iterator() {
        return new BagIterator();
    }

    // Step 3: white a class than Iterator implement
    private class BagIterator implement Iterator<Item> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            Item item = current.item;
            current   = current.next;
            return item;
        }
        public void remove() {
            throw new UnsupprtedOperationException();
        }
    }
}
