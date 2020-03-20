import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class ClientStackInteger {
    public static void main(String[] args) {
        StackOfInteger stacks;
        stack = new StackOfInteger(20);

        while (!StdIn.isEmpty()) {
            Integer in = StdIn.readInteger();
            if(!in.equal("-"))
                stack.push(in);
            else if (!stack.isEmpty())
                StdOut.println(stack.pop() + " ");
        }
        StdOut.println("(" + stack.size() + " left on stack)");
    }
}
