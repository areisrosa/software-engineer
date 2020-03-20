public class Binary
{
    public static String convert(int n)
    {
        if (n == 1) return "1";
        return convert(n/2) + (n % 2); // int 0 or 1 automatically converted to
                                       // String "0" or "1".
    }
    public static void main(String[] args)
    {
        int n = Integer.parseInt(args[0]);
        StdOut.println(convert(n));
    }
}
