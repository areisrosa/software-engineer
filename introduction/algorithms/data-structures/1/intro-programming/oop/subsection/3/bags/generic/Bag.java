public class Bag<Item> {
    private Node first;
    private int n;
    private Node current;

    private class Node {
        private Item item;
        private Node next;
    }

    public Bag() { // construct
        first = null;
    }

    public void add(Item item) {
       Node oldfirst = first;
       first = new Node();
       first.item = item;
       first.next = oldfitst;
       n++;
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public void startIterator() {
        current = first;
    }

    public boolean hasNext() {
        return  current != null;
    }

    public Item next() {
        Item item = current.item;
        current = current.next;
        return item;
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }
}
