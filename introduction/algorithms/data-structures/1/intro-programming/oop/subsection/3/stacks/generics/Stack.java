// Item is generic type, or type parameter, will have to be replaced from a
// concrete type when an instance stack is create.
// Note: a @casting  a = (Item[]) new Object[1]; and a = (Item[]) new Object[cap];

public class Stack<Item> {
    
    private Item[] a = null;
    private int    n = 0;

    public Stack(int cap) {
        a = (Item[]) new Object[cap];
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void push(Item item) {
        a[n++] = item;
    }

    public Item pop() {
        return a[--n];
    }
}
