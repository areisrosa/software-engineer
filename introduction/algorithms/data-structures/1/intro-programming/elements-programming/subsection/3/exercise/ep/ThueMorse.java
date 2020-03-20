public final class ThueMorse
{
    public ThueMorse() {
        throw new AssertionError("Instantiating utility class.");
    }
    public static void main(String[] args)
    {
        int n = Integer.parseInt(args[0]);
        int[] a = new int[n];
        /******************************************************************
         * build up Thue-Morse sequence
         ******************************************************************/
        for (int i = 0; i < a.length; i++) {
            a[0] = 0;
            if (i % 2 == 0) {
                a[i] = a[i/2];
            } else {
                a[i] = 1 - a[i-1];
            }
        }
        /******************************************************************
         * To visualize the Thue–Morse sequence, create an n-by-n pattern by
         printing a + (plus sign) in row i and column j if bits i and j in the
         sequence are equal, and a - (minus sign) if they are different.
         ******************************************************************/
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (a[i] == a[j]) {
                    System.out.print("+" + " ");
                } else {
                    System.out.print("-" + " ");
                }
            }
            System.out.println();
        }
    }
}
