import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class ClientStackString {
    public static void main(String[] args) {
        StackOfString stack;
        stack = new StackOfString(20);

        while (!StdIn.isEmpty()) {
            String str = StdIn.readString();
            if (!str.equals("-"))
                stack.push(str);
            else if (!stack.isEmpty())
                StdOut.println(stack.pop() + " ");
        }
        StdOut.println("(" + stack.size() + " left on stack)");
    }

