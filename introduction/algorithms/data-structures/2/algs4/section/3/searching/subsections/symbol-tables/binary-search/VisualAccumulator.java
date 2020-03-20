import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdDraw;

public class VisualAccumulator
{
    private double total;
    private int n;

    public VisualAccumulator(int trials, double max) {
        StdDraw.setXscale(0, trials);
        StdDraw.setYscale(0, max);
        StdDraw.setPenRadius(.005);
    }
    
    public void addDataValue(double val) {
        n++;
        total += val;
        StdDraw.setPenColor(StdDraw.DARK_GRAY);
        StdDraw.point(n, val);
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.point(n, total/n);
    }
    
    public double mean() {
        return total/n;
    }
    
    public String toString() { 
        return "Mean (" + n + " values): " 
            + String.format("%7.5f", mean());
    }
    /**
     * Unit tests the {@code VisualAccumulator} data type.
     * Reads in a stream of real number from standard input;
     * adds them to the accumulator; and prints the mean,
     * sample standard deviation, and sample variance to standard
     * output.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        int maxT = Integer.parseInt(args[0]);
        VisualAccumulator a = new VisualAccumulator(maxT, 1.0);
        for (int t = 0; t < maxT; t++) 
            a.addDataValue(StdRandom.random());
        StdOut.println(a);
    }
}
