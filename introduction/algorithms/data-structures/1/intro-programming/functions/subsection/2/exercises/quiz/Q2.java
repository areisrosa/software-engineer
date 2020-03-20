public class Q2
{
    public static int Q(int n)
    {
        if (n <= 0) return 1;
        return 1 + Q(n-2) + Q(n-3);
    }
    public static void main(String[] args)
    {
        int n = Integer.parseInt(args[0]);
        System.out.println(Q(n));
    }
}
