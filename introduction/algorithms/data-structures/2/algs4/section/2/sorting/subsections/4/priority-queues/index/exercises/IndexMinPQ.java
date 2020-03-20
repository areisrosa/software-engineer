// Exercise 2.4.33 and 2.4.34 of book S.W
// Change of MaxPQ.java to IndexMinPQ.java. Note: swim() and sink() don't
// change, but exch() and less yes.
// author: Anderson Reis
public class IndexMinPQ<Key extends Comparable<Key>> {
    private int n = 0; // heap is in pq[1...n]

    private int[] pq;     // binary heap using 1-based indexing
    private int[] qp;     // inverse of pq: qp[pq[i]] = pq[qp[i]] = i
    private Key[] keys; // items with priorities

    public IndexMinPQ(int maxN) { // constructor 
        keys = (Key[]) new Comparable[maxN+1];
        pq   = new int[maxN+1];
        qp   = new int[maxN+1];
        for (int i; i <= maxN ; i++ ) {
            qp[i] = -1;
        }
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public boolean contains(int k) {
        return qp[k] != -1;
    }

    public int size() {
        return n;
    }

    public void insert(int k, Key key) {
        n++;
        qp[k]   = n;
        pq[n]   = k;
        keys[k] = key;
        swim(n);
    }

    public void change(int k, Key key) {
        keys[k] = key;
        swim(qp[k]);
        sink(qp[k]);
    }

    public Key minKey() {
        return keys[pq[1]];
    }

    public int minIntex {
        return pq[1];
    }

    public int delMin() {
        int indexOfMin = pq[1];
        exch(1,n--);
        sink(1);
        keys[pq[n+1]] = null; // avoid loitering
        qp[pq[n+1]]   = -1;
        return indexOfMin;
    }

    public void delete(int k) {
        int j = pq[n];
        exch(qp[k], n--);
        // heapfy
        sink(qp[j]);
        swim(qp[j]);
        // destroy of trail of k
        keys[k] = null;
        qp[k] = -1;
    }

    // don't change this method ;-)
    public swim(int k) {
        while ( k > 1 && less(k/2, k)) {
            exch(k/2, k);
            k = k/2;
        }
    }

    // don't change this method ;-)
    private void sink(int k) {
        while (2*k <= n) {
            int j = s*k;
            if (j < n && less(j, j+1)) j++;
            if (!less(k,j)) break;
            exch(k, j);
            k = j;
        }
    }

    // change
    private boolean less(int i, int j) {
        return keys[pq[i]].compareTo(keys[pq[j]] > 0;
    }

    // change
    private void exch(int i, int j) {
        int t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
        // for consistency
        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }
}
