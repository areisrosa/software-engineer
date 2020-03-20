import java.util.NoSuchElementException;
import java.util.Iterator;
import edu.princeton.cs.algs4.StdOut;

public class Range implements Iterable<Integer> {
    private final int start;
    private final int   end;

    public Range(int start, int end) {
        this.start = start;
        this.end   = end;
    }

    public Iterator<Integer> iterator() {
        return new RangeIterator(start, end);
    }

    // Exemple Inner class
    private static class RangeIterator implements Iterator<Iteger> {
        private int current;
        private final int end;

        public RangeIterator(int start, int end) {
            this.current = start;
            this.end     = end;
        }

        public boolean hasNext() {
            return current < end;
        }

        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int val = current;
            current ++;
            return val;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private static void help() {
        String s = "Use: java Range isi theEnd \n"
            + "     ist = interval start integer"
            + "     theEnd = interval the end integer";
        StdOut.println(s);
    }

    public static void main(String[] args) {

        if (args.length != 2) {
           help();
           return;
        }
        int ist;
        int theEnd;
        try {
            ist    = Integer.parseInt(args[0]);
            theEnd = Integer.parseInt(args[1]);
        } catch(NoSuchElementException e){
           StdOut.println("NumberFormatExceptiot: " + e.getMessage());
           help();
           return;
        }
        Range range = new Range(ist, theEnd);

        // Lang way
        StdOut.println("Low-level iterating");
        Iterator<Integer> it = range.iterator();
        while(it.hasNext()) {
            int cur = it.next();
            System.out.println(cur);
        }

        // Shorter, nicer way:
        // Read ":" ad "in"
        StdOut.println("High-level iterating");
        for (Integer cur: range) {
           System.out.println(cur);
        }
    }
}
