public class BagInteger {
    private Node first;
    private int n;
    private Node current;

    private class Node {
        private Integer item;
        private Node next;
    }

    public BagInteger() { // constructor
        first = null;
    }

    public void add(Integer item) { // insert items in bag
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        n++;
    }

    public int size() { // number of items in the bag
        return n;
    }

    public boolean isEmpty() { // is the bag empty?
        return n == 0;
    }

    public void startIterator() {
        current = first;
    }

    public boolean hasNext() { // are there items to be iterate?
        return current != null;
    }

    public Integer next() { // next item
        Integer item = current.item;
        current = current.next;
        return item;
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }
}
