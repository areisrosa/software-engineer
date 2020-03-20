public class StackOfInteger {
    private int[] a = null;
    private int   n = 0;

    public StackOfInteger(int cap) {
        a = new int[cap];
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void push(int item) {
        a[n++] = item;
    }

    public Integer pop() {
        return a[--n];
    }

    // unit test
    public static void main(String[] args) {
        
    }
}
