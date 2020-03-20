/** ***********************************************************************
 *  Compilation:  javac LinkedListST.java
 *  Execution:    java LinkedListST
 *  Dependencies: StdIn.java StdOut.java
 *  Data files:   http://algs4.cs.princeton.edu/31elementary/tinyST.txt  
 *  
 *  Symbol table implementation with an ordered linked list.
 *
 *  % more tinyST.txt
 *  S E A R C H E X A M P L E
 *  
 *  % java LinkedListST < tinyST.txt
 *  A 8
 *  C 4
 *  E 12
 *  H 5
 *  L 11
 *  M 9
 *  P 10
 *  R 3
 *  S 0
 *  X 7
 *
 *************************************************************************/

import edu.princeton.cs.algs4.StdIn; 
import edu.princeton.cs.algs4.StdOut; 
import java.util.Iterator; 

/** This is an implementation of a symbol table whose keys are comparable.
 * The keys are kept in increasing order in an linked list.
 * Following our usual convention for symbol tables, 
 * the keys are pairwise distinct.
 * <p>
 * For additional documentation, see 
 * <a href="http://algs4.cs.princeton.edu/31elementary/">Section 3.1</a> 
 * of "Algorithms, 4th Edition" (p.378 of paper edition), 
 * by Robert Sedgewick and Kevin Wayne.
 *
 */

public class LinkedListST<Key extends Comparable<Key>, Value> {
    private Node first;
    private int n = 0;   // number of (key,value) pairs in the table

    private class Node {
        Key   key;
        Value val;
        Node next;
       }
    
    /** Constructor.
     * Creates an empty symbol table with default initial capacity.
     */
    public LinkedListST() {
        first = new Node();
    }

    /** Is the key in this symbol table?
     */
    public boolean contains(Key key) {
        Node p = first;
        for (p = first; p != null && p.key.compareTo(key) < 0; p = p.next);
        if (p == null)
            return false;
        return p.key.compareTo(key) == 0;
    }

    /** Returns the number of (key,value) pairs in this symbol table.
     */
    public int size() { return n; }

    /** Is this symbol table empty?
     */
    public boolean isEmpty() { return first.next == null; }

    /** Returns the value associated with the given key, 
     *  or null if no such key.
     *  Argument key must be nonnull.
     */
    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to get() is null");
        Node p = first.next;
        while (p != null && p.key.compareTo(key) < 0) p = p.next;
        if (p != null && p.key.compareTo(key) == 0) return p.val;
        return null;
    }
    
    /** Returns the number of keys in the table 
     *  that are strictly smaller than the given key.
     *  Argument key must be nonnull.
     */
    public int rank(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to rank() is null");

        int lo = 0;
        Node p = first.next;
        while (p != null && p.key.compareTo(key) < 0) {
            p = p.next;
            lo++;
        }
        return lo;
    
    /** Search for key in this symbol table. 
     * If key is in the table, update the corresponing value.
     * Otherwise, add the (key,val) pair to the table.
     * Argument key must be nonnull.
     * If argument val is null, the key must be deleted from the table.
     */
    public void put(Key key, Value val)  {
        if (key == null) throw new IllegalArgumentException("argument to put() is null");
        if (val == null) {
            delete(key);
            return;
        }

        Node p = prev(key);
        Node q = p.next;
        // key is not in the table
        if (q == null || q.key.compareTo(key) > 0) {
            p.next = new Node(key, val, q);
            n++;
            if (q == null) last = p.next;
            return;
        }
        // key is in the table
        q.val = val;
    } 


    /** Remove key (and the corresponding value) from this symbol table.
     * If key is not in the table, do nothing.
     */
    public void delete(Key key)  {
        if (key == null) throw new IllegalArgumentException("argument to put() is null");
        if (isEmpty()) return;

        Node p = prev(key);
        Node q = p.next;
        // key is in the table
        if (q != null && q.key.compareTo(key) == 0) {
            p.next = q.next;
            if (p.next == null) last = p;  
            n--;
            return;
        }
    } 

    /** Delete the minimum key and its associated value
     * from this symbol table.
     * The symbol table must be nonempty.
     */
    public void deleteMin() {
        if (isEmpty()) throw new java.util.NoSuchElementException("deleteMin(): Symbol table underflow error");

        delete(min());
    }

    /** Delete the maximum key and its associated value
     * from this symbol table.
     */
    public void deleteMax() {
        if (isEmpty()) throw new java.util.NoSuchElementException("deleteMax(): Symbol table underflow error");

        delete(max());
        
    }

   /***************************************************************************
    *  Ordered symbol table methods
    **************************************************************************/

    /** Returns the smallest key in this table.
     * Returns null if the table is empty.
     */
    public Key min() {
        if (first.next == null) return null;
        return first.next.key;
    }

   
    /** Returns the greatest key in this table.
     * Returns null if the table is empty.
     */
    public Key max() {
        if (first.next == null) return null;
        return last.key;
    }

    /** Returns a key that is strictly greater than 
     * (exactly) k other keys in the table. 
     * Returns null if k < 0.
     * Returns null if k is greater that or equal to 
     * the total number of keys in the table.
     */
    public Key select(int k) {
        if (k < 0 || k >= n) return null;
        Node p = first.next;
        for (int i = 0; i < k; i++) {
            p = p.next;
        }
        return p.key;
    }

    /** Returns the greatest key that is 
     * smaller than or equal to the given key.
     * Argument key must be nonnull.
     * If there is no such key in the table
     * (i.e., if the given key is smaller than any key in the table), 
     * returns null.
     */
    public Key floor(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to floor() is null");

        Node p = prev(key);
        if (p == first) return null;
        return p.key;
    }

    /** Returns the smallest key that is 
     * greater than or equal to the given key.
     * Argument key must be nonnull.
     * If there is no such key in the table
     * (i.e., if the given key is greater than any key in the table), 
     * returns null.
     */
    public Key ceiling(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to ceiling() is null");

        Node p = prev(key);
        Node q = p.next;
        if (q == null) return null;
        return q.key;
    }

    /** Returns all keys in the symbol table as an Iterable.
     * To iterate over all of the keys in the symbol table named st, use the
     * foreach notation: for (Key key : st.keys()).
     */
    public Iterable<Key> keys() {
        return new ListKeys();
    }

    /**
     * implements Iterable<Key> significa que essa classe deve 
     * ter um método iterator(), acho...
     */
    private class ListKeys implements Iterable<Key> {
        /** 
         * Devolve um iterador que itera sobre os itens da ST 
         * da menor até a maior chave.<br>
         */
        public Iterator<Key> iterator() {
            return new KeysIterator();
        }
        
        private class KeysIterator implements Iterator<Key> {
            // variáveis do iterador
            private Node current = first.next; //f//
            
            public boolean hasNext() {
                // escreva seu método a seguir
                return current != null; //f//
            }

            public Key next() {
                // escreva seu método a seguir
                // beginfora
                if (current == null) {
                    throw new java.util.NoSuchElementException("KeysIterator.next(): no next key");
                }
                Key key = current.key;
                current = current.next;
                return key;
                // endfora
            }
                    
            public void remove() { 
                throw new UnsupportedOperationException(); 
            }
        }
    }


   /***************************************************************************
    *   Check internal invariants: pode ser útil durante o desenvolvimento 
    **************************************************************************/
    // beginfora
    /** Returns first if the ST is empty and a reference to the node first 
     *  node p such that p.next.compateTo(Key) >= 0 otherwise.
     *  Argument key must be nonnull.
     */
    private Node prev(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to rank() is null");
        Node p = first;
        Node q = first.next;
        while (q != null && q.key.compareTo(key) < 0) {
            p = q;
            q = q.next;
        }
        return p;
    } 
    // endfora
    
    // are the items in the linked list in ascending order?
    private boolean isSorted() {
        Node p = first.next;
        if (p == null) return true;    
        for (Node q = p.next; q != null; q = p.next) {
            if (q.key.compareTo(p.key) < 0) return false;
            p = p.next;
        }
        return true;
    }

   /** Test client.
    * Reads a sequence of strings from the standard input.
    * Builds a symbol table whose keys are the strings read.
    * The value of each string is its position in the input stream
    * (0 for the first string, 1 for the second, and so on).
    * Then prints all the (key,value) pairs.
    */
    public static void main(String[] args) { 
        LinkedListST<String, Integer> st;
        st = new LinkedListST<String, Integer>();
        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            st.put(key, i);
        }
        for (String s : st.keys())
            StdOut.println(s + " " + st.get(s));
    }
}
