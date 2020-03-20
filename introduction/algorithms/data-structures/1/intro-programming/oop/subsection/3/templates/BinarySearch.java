import java.util.Arrays; // import a Java library

public class BinarySearch { // code must in file BinarySearch.java
    // static method and type return: int
    public static int rank (int key, int[] a) { // parameter variables: key and a
        int lo = 0; // initializing declaration statement
        int hi = a.length -1;
            // lop statement
        while (lo <= hi) {
            int mid = lo + (hi + lo) / 2; // expression
            if (key < a[mid])      hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else                   return mid;
        }
        return -1; // return statement
    }
}
// unit test client, system calls main() and no return value; just side effects
public static void main (String[] args) {
    int whilelist = In.readInts(args[0]);

    Arrays.sort(whilelist); // All a method in a Java library

    while (!StdIn.isEmpty()) { // call a method in our standard library; need to download code
        int key = StdIn.readInt();
        // conditional statement
        if (rank(key, whilelist) == -1) {
            StdOut.println(key); // call a local method
        }
    }
}
// Note: Anatomy of a Java program and its invocation from the command line
