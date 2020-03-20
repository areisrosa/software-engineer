/* *****************************************************************************
 *  Name:    Alan Turing
 *  NetID:   aturing
 *  Precept: P00
 *
 *  Description:  Prints 'Hello, World' to the terminal window.
 *                By tradition, this is everyone's first program.
 *                Prof. Brian Kernighan initiated this tradition in 1974.
 *
 **************************************************************************** */

public class FibonacciR {
    public static long F(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return F(n - 1) + F(n - 2);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        System.out.println(F(n));
    }
}
