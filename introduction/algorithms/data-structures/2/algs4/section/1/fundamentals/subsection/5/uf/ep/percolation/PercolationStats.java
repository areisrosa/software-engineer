import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.StdOut;

public class PercolationStats {
    private final int trial;
    private final double[] fractionTrials;

    // Perform trials independent experiments on an n-by-n grid
    public PercolationStats(int n, int trials) {

        validate(n, trials);
        int col;
        int row;
        trial = trials;
        fractionTrials = new double[trials];

        for (int i = 0; i < trials; i++) {
            Percolation pr = new Percolation(n);
            while (!pr.percolates()) {
                col = StdRandom.uniform(n) + 1;
                row = StdRandom.uniform(n) + 1;
                pr.open(row, col);
            }
            fractionTrials[i] = (double) pr.numberOfOpenSites() / (n * n);
        }
    }

    private void validate(int n, int t) {
        if (n <= 0 || t <= 0) {
            throw new IllegalArgumentException("Given n <= 0 or t <= 0");
        }
    }

    // Sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(fractionTrials);
    }

    // Sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(fractionTrials);
    }
    // Low endpoint of 95% confidence interval
    public double confidenceLo() {
        return mean() - 1.96 * stddev() / Math.sqrt(trial);
    }

    // High endpoint of 95% confidence interval
    public double confidenceHi() {
        return mean() + 1.96 * stddev() / Math.sqrt(trial);
    }

    // Test client (described below)
    public static void main(String[] args) {
        int n      = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        PercolationStats percolationStats = new PercolationStats(n, trials);

        System.out.println("mean                    = " + percolationStats.mean());

        System.out.println("stddev                  = " + percolationStats.stddev());

        System.out.println("95% confidence interval = [" + percolationStats.confidenceLo() + ", " + percolationStats.confidenceHi() + "]");
    }
}
