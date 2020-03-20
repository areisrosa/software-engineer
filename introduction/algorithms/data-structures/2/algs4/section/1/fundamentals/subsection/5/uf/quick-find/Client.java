import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Client {
  /**
     * Reads in an integer {@code n} and a sequence of pairs of integers
     * (between {@code 0} and {@code n-1}) from standard input, where each
     * integer in the pair represents some element;
     * if the elements are in different sets, merge the two sets and print the
     * pair to standard output.
     *
     * @param args the command-line argumenst
     */
    public static void main(String[] args) {
        int n = StdIn.readInt();
        QuickFindUF uf = new QuickFindUF(n);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            StdOut.println(p + " " + q);
            if (uf.find(p) == uf.find(q)) continue;
            uf.union(p, q);
            StdOut.println(uf.count() + " components");
        }
    }
}

