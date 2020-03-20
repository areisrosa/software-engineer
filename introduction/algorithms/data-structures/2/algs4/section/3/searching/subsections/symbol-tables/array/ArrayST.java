/******************************************************************************
 * Compilation:  javac Array.java
 * Execution:    java ArrayST < input.txt
 * Dependencies: StdIn.java StdOut.java
 * Data files:   https://algs4.cs.princeton.edu/31elementary/tinyST.txt
 *
 * Symbol table implementation with unordered array. Use repeated doubling to 
 * resize the array.
 *
 * % java ArrayST < tiny.txt
 * S 0
 * H 5
 * X 7
 * R 3
 * C 4
 * L 11
 * A 8
 * M 9
 * P 10
 * E 12
 *
 ******************************************************************************/

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class ArrayST<Key, Value> {
    private static final int INITIAL_SIZE = 8;

    private Value[] vals; // symbol table values
    private Key[]   keys; // symbol table keys
    private int     n= 0; // number of elements in symbol table

        keys = (Key[])   new Object[INITIAL_SIZE];
        vals = (Value[]) new Object[INITIAL_SIZE];
    }
    // return the number of key-value pairs in symbol table
    public int size() {
        return n;
    }
    // is the symbol table empty?
    public boolean isEmpty() {
        return size() == 0;
    }
    // remove given key (and associated value)
    public void delete(Key key) {
        for (int i = 0; i < n; i++) {
            if (key.equals(keys[i])) {
                keys[i] = keys[n-1];
                vals[i] = vals[n-1];
                keys[n-1] = null;
                vals[n-1] = null;
                n--;
                if (n > 0 && n == keys.length/4) resize(keys.length/2);
                return;
            }
        }
    }
    // resize the parallel arrays to the given capacity
    private void resize(int capacity) {
        Key[]   tempk = (Key[])   new Object[capacity];
        Value[] tempv = (Value[]) new Object[capacity];
        for (int i = 0; i < n; i++)
            tempk[i] = keys[i];
        for (int i = 0; i < n; i++)
            tempv[i] = vals[i];
        keys = tempk;
        vals = tempv;
    }
    // insert the key-value pair into the symbol table
    public void put(Key key, Value val) {
        // to deal with duplicates
        delete(key);
        // double size of arrays if necessary
        if (n >= vals.length) resize(2*n);
        // add new key and value at the end of array
        keys[n] = key;
        vals[n] = val;
        n++;
    }
    // search the value associated with a given key
    public Value get(Key key) {
        for (int i = 0; i < n; i++)
            if (keys[i].equals(key)) return vals[i];
        return null;
    }
    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        for (int i = 0; i < n; i++)
            queue.enqueue(keys[i]);
        return queue;
    }
    /***************************************************************************
     * Test routine.
     ***************************************************************************/
    public static void main(String[] args) {
        ArrayST<String, Integer> st = new ArrayST<String, Integer>();
        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            st.put(key, i);
        }
        for (String string : st.keys())
            StdOut.println(string + " " + st.get(s));
    }
}
