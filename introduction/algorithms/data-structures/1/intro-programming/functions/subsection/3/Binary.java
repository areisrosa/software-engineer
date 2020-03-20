/* *****************************************************************************
 *  Name:    Anderson Reis
 *  NetID:   areis
 *  Precept: Recursion
 *
 *  Description:  To compute a function of a positive integer N.
 *                  * Base case:
 *                    - Return a value for small N.
 *                  * Reduction step:
 *                    - Assuming that it works for smaller value of its argument
 *                      use the function to compute a return value for N.
 * Question:
 * - How can we br convinced that this method is correct?
 *
 * Answer:
 * - Use mathematical induction.
 *
 **************************************************************************** */

public class Binary {
    public static String convert(int N) {
        if (N == 1) return "1";
        return convert(N / 2) + (N % 2);    // int 0 or 1 automatically converted to
                                            // String "0" or "1";
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        System.out.println(convert(N));
    }
}
