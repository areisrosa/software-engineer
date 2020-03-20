public class Collatz
{
    public static int collatz(int n)
    {
        StdOut.print(n + " ");
        if (n == 1) return 0;
        if (n % 2 == 0) return collatz(n / 2);
        return collatz(3*n + 1); 
    }

    public static void main(String[] args)
    {
        int n = Integer.parseInt(args[0]);
        System.out.println(collatz(n));
    }
}
