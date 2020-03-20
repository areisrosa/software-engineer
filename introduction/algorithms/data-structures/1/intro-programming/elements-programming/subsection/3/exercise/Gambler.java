public class Gambler 
{
    public static void main(String[] args)
    {
        int stake = Integer.parseInt(args[0]);
        int goal = Integer.parseInt(args[1]);
        int trials = Integer.parseInt(args[2]);

        int wins = 0;
        for (int i = 0; i < trials; i++) 
        {
            int t = stake;
            while (t > 0 && t < goal) 
            {
                if (Math.random() < 0.5) t++;
                else                     t--;
            }
            if (t == goal) wins++;
        }
        System.out.println(wins + " wins of" + trials);
    }
}
