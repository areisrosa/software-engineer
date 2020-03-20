public class StackOfString {
    private String[] a = null;
    private int = 0;

    public StackOfString(int cap) {
        a = new String[cap];
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void push(String item) {
        a[n++] = item;
    }

    public String pop() {
        return a[--n];
    }

    // unit test 
    public static void main(String[] args) {  

    }
}
