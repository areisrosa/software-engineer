import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class Driver {
    public static void main(String[] args) {
        int n = StdIn.readInt();
        Stopwatch timer = new Stopwatch();
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(n);
        int line = 0;
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            StdOut.println(line + ":" + p + " " + q);
            line++;
            if (uf.find(p) == uf.find(q)) continue;
            uf.union(p, q);
        }
        StdOut.println(uf.count() + " components");
        double time = timer.elapsedTime();
        StdOut.println(time + "seg");
    }
}
