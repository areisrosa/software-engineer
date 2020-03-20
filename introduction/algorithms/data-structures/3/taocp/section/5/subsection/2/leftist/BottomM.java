import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Transaction;

public class BottomM {
    public static void main(String[] args) {
        int M = Integer.parseInt(args[0]);
        MaxLeftist<Transaction> pq = new MaxLeftist<Transaction>();
        while (StdIn.hasNextLine()) {
            Transaction transaction = new Transaction(StdIn.readLine());
            pq.insert(transaction);
            if (pq.size() > M)
                pq.delMax();
        }

        // The transactions less M are in PQ
        Stack<Transaction> stack = new Stack<Transaction>();
        while (!pq.isEmpty())
            stack.push(pq.delMax());
        for (Transaction transaction : stack) // foreach
            StdOut.println(transaction);
    }
}
