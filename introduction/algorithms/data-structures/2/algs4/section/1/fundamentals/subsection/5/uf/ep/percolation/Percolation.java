/******************************************************************************
 *
 *  Compilation:  javac-algs4 PercolationStats.java
 *  Execution:    java-algs4 PercolationStats 200 100
 *
 *  @author Anderson Reis
 *
 ******************************************************************************/

/**
 * {@code Percolation} given a composite systems comprised of randomly
 * distributed insulating and metallic materials: what fraction of the materials
 * need to be metallic so that the composite system is an electrical conductor?
 * Given a porous landscape with water on the surface (or oil below), under what
 * conditions will the water be able to drain through to the bottom (or the oil
 * to gush through to the surface)? Scientists have defined an abstract process
 * known as percolation to model such situations. 
 *
 * <em>The model</em>. We model a percolation system using an n-by-n grid of
 * sites. Each site is either open or blocked. A full site is an open site that
 * can be connected to an open site in the top row via a chain of neighboring
 * (left, right, up, down) open sites. We say the system percolates if there is
 * a full site in the bottom row. In other words, a system percolates if we fill
 * all open sites connected to the top row and that process fills some open site
 * on the bottom row. (For the insulating/metallic materials example, the open
 * sites correspond to metallic materials, so that a system that percolates has
 * a metallic path from top to bottom, with full sites conducting. For the
 * porous substance example, the open sites correspond to empty space through
 * which water might flow, so that a system that percolates lets water fill open
 * sites, flowing from top to bottom.) 
 *
 * <em>The problem</em>. In a famous scientific problem, researchers are
 * interested in the following question: if sites are independently set to be
 * open with probability <em>p</em> (and therefore blocked with probability
 * <em>1−p</em>), what is the probability that the system percolates? When
 * <em>p</em> equals 0, the system does not percolate; when <em>p</em> equals 1,
 * the system percolates. The plots below show the site vacancy probability
 * <em>p</em> versus the percolation probability for 20-by-20 random grid (left)
 * and 100-by-100 random grid (right).
 *
 * When n is sufficiently large, there is a threshold value <em>p*</em> such
 * that when <em>p</em> > <em>p*</em> a random n-by-n grid almost never
 * percolates, and when <em>p</em> > <em>p*</em>, a random n-by-n grid almost
 * always percolates. No mathematical solution for determining the percolation
 * threshold <em>p*</em> has yet been derived. Your task is to write a computer
 * program to estimate <em>p*</em>. 
 *
 */

import edu.princeton.cs.algs4.WeightedQuickUnionUF;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Percolation {

    private final WeightedQuickUnionUF uf;
    private final WeightedQuickUnionUF ufBackwash;
    private boolean[] id;
    private int numberOfOpenSites;
    private final int p;

    // Creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        validate(n);
        uf         = new WeightedQuickUnionUF(n * n + 2);
        ufBackwash = new WeightedQuickUnionUF(n * n + 2);
        id         = new boolean[n * n];
        p = n;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                id[(i-1) * n + j-1] = false;
            }
        }
        numberOfOpenSites = 0;
    }

    // Validates that the size of the grid is a positive integer
    private void validate(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException(
                    "Size of n cannot be less than or equal to 0");
        }
    }

    /**
     * Opens the size ({@code row}, {@code col}) if its is not already open.
     * By convention, (0, 0) is the upper-left site.
     *
     * @param row an element
     *                      row index in range [0, n-1]
     * @param col an element
     *                      column index in range [0, n-1]
     * @throws IllegalArgumentException unless {@code n <= 0}
     *
     */
    public void open(int row, int col) {
        int n = p;
        if (row > n || row < 1 || col > n || col < 1) {
           validate(n); 
        }
        if (!id[n * (row - 1) + col - 1]) {
            id[n * (row - 1) + col - 1] = true;
            numberOfOpenSites += 1;
            if (row != 1 && id[n * (row - 2) + col - 1]) {
                uf.union(n * (row - 1) + col - 1, n * (row - 2) + col - 1);
                ufBackwash.union(n * (row - 1) + col - 1, n * (row - 2) + col - 1);
            }
            if (col != 1 && id[n * (row - 1) + col - 2]) {
                uf.union(n * (row - 1) + col - 1, n * (row - 1) + col - 2);
                ufBackwash.union(n * (row - 1) + col - 1, n * (row - 1) + col - 2);
            }
            if (row < n && id[n * row + col - 1]) {
                uf.union(n * (row - 1) + col - 1, n * row + col - 1);
                ufBackwash.union(n * (row - 1) + col - 1, n * row + col - 1);
            }
            if (col < n && id[n * (row - 1) + col]) {
                uf.union(n * (row - 1) + col - 1, n * (row - 1) + col);
                ufBackwash.union(n * (row - 1) + col - 1, n * (row - 1) + col);
            }
            if (row == 1) {
                uf.union(n * (row - 1) + col - 1, n * n + 1);
                ufBackwash.union(n * (row - 1) + col - 1, n * n + 1);
            }
            if (row == n) {
                uf.union(n * (row - 1) + col - 1, n * n);
            }
        }
    }

    /**
     * Is the size ({@code row}, {@code col}) open?
     * Returns true if and only if site (row, col) is open.
     *
     * @param row an element
     *                      row index in range [0,n-1]
     * @param col an element
     *                      column index in range [0,n-1]
     * @throws IllegalArgumentException unless {@code n <= 0}
     *
     */
    public boolean isOpen(int row, int col) {
        int n = p;

        if (row > n || row < 1 || col > n || col < 1) {
            validate(n);
        }
        return id[n * (row - 1) + col - 1];
    }

    /**
     * Is the size ({@code row}, {@code col}) full?
     * Returns true if and only if site (row, col) is full
     *
     * @param row an element
     *                      row index in range [0,n-1]
     * @param col an element
     *                     column index in range [0,n-1]
     * @throws IllegalArgumentException unless {@code n <= 0}
     *
     */
    public boolean isFull(int row, int col) {
        int n = p;
        if (row > n || row < 1 || col > n || col < 1) {
            validate(n);
        }
        return (id[n * (row - 1) + col - 1] && ufBackwash.find(n*(row-1) + col-1) == ufBackwash.find(n*n+1));
    }

    // Returns the number of open sites
    public int numberOfOpenSites() {
        return numberOfOpenSites;
    }

    // Does the system percolate?
    public boolean percolates() {
        int n = p;
        return (uf.find(n * n) == uf.find(n * n + 1));
    }
}
