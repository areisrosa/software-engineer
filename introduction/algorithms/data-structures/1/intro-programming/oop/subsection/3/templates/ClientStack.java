/******************************************************************************
 *  Compilation:  javac-algs4 ClientStack.java
 *  Execution:    java-algs4 ClientStack
 *  Data files:   https://introcs.cs.princeton.edu/java/43stack/tobe.txt
 *  
 *  Stack of strings implementation with a fixed-size array.
 *
 *  % more tobe.txt 
 *  to be or not to - be - - that - - - is 
 * 
 *  % java ClientStack 5 < tobe.txt 
 *  to be not that or be
 *
 ******************************************************************************/
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ClientStack {
    public static void main (String[] args) {
        Stack<String> stack;
        stack = new Stack<String>();

        while (!StdIn.isEmpty()) {
            String str = StdIn.readString();
            if (!str.equals("-")) {
                stack.push(str);
            }
            else (!stack.isEmpty()) {
                StdOut.print(stack.pop() + "");
            }
        }
        StdOut.println("(" + stack.size() + ") left on stack");
    }
}
