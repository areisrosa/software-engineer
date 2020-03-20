public class MaxLeftist<Item extends Comparable<Item>> {
    private Node root;
    private int n;

    private class Node {
        private Item item;
        private Node left, right;
        private int dist;

        public Node(Item item, Node left, Node right, int dist) {
            this.item  = item;
            this.left  = left;
            this.right = right;
            this.dist  = dist;
        }

        public String toString() {
            String string = "{Item: " + item + "(" + left + "),[" + right + "] "
                + dist + "}";
            return string;
        }
    }

    /**
     * Initializes an empty priority queue.
     */
    public MaxLeftist() {  }

    public boolean isEmpty() {
        return root == null;
    }

    public int size() {
        return n;
    }

    public void insert(Item item) {
        Node string = new Node(item, null, null, 1);
        root        = merge(root, string);
        n++;
    }

    public Item delMax() {
        Item max = root.item;
        root     = merge(root.left, root.right);
        n--;
        return max;
    }

    /**
     * Transforms this into the union of "this" and "that",
     */
    public void union(MaxLeftist<Item> that) {
        if (that == null) return;
        this.root = merge(this.root, that.root);
        this.n    = this.n + that.n;
    }
    /** in the code for the union method above, the reserved word "this" serves
     * to resolve the ambiguity around root variables. Thus, that.root is the
     * root variable of the MaxLeftist<Item> object that we are defining, while
     * this.root is the root variable of the union method which is a parameter
     * of the union().
    */

    // Administrative method to maintain consistency of Leftist heap
    private Node merge(Node root1, Node root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;

        // root1 != null and root2 != null
        if (less(root1, root2)) {
            Node swap = root1;
                        root1 = root2;
                             root2 = swap;
        }

        // root1 points to the biggest item
        if (root1.left == null) root1.left = root2;
        else {
            root1.right = merge(root1.right, root2);
            if (root1.left.dist < root1.right.dist) {
                // exchange left and right
                Node swap = root1.left;
                            root1.left = root1.right;
                                         root1.right = swap;
            }
            root1.dist = root1.right.dist + 1;
        }
        return root1;
    }

    private boolean less(Node i, Node j) {
        return i.item.compareTo(j.item) < 0;
    }
}
