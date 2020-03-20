import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class Driver {
    public static void main(String[] args) {
        int n = StdIn.readInt();
        Stopwatch timer = new Stopwatch();
        QuickFindUF uf = new QuickUnionUF(n);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (!uf.connected(p, q)) {
                uf.union(p, q);
                // StdOut.println(p + " " + q);
            }
        }
        StdOut.println(uf.count() + " components");
        double time = timer.elapsedTime();
        StdOut.println(time + "seg");
    }
}
