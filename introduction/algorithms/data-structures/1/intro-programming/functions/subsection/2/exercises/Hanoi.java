public class Hanoi
{
    public static void hanoi(int n, boolean left)
    {
        if (n == 0) return;
        hanoi(n-1,!left);
        if (left) StdOut.println(n + " Left");
        else      StdOut.println(n + " Right");
        hanoi(n-1,!left);
    }

    public static void main(String[] args)
    {
        int n = Integer.parseInt(args[0]);
        hanoi(n, true);
    }
}
