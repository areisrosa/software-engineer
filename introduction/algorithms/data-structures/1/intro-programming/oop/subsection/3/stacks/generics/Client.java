import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class ClientStack<Item> {
    public static void main(String[] args) {
        Stack<Item> stack;
        stack = new Stack<Item>(20);

        while (!StdIn.isEmpty()) {
            Item item = StdIn.readItem();
            if (!item.equals("-"))
                stack.push(item);
            else if (!stack.isEmpty())
                StdOut.println(stack.pop() + " ");
        }
        StdOut.println("(" + stack.size() + " left on stack");
    }
}
