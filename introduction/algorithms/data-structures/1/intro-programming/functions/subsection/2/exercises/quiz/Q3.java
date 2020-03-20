public class Q3
{
    public static void Q(int n)
    {
        if (n <= 0) return;
        StdOut.println(n);
        Q(n-2);
        Q(n-3);
        StdOut.println(n);
    }
    public static void main(String[] args)
    {
        int n = Integer.parseInt(args[0]);
        Q(n);
    }
}
