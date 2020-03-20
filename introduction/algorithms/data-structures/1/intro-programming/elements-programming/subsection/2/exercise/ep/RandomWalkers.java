import java.util.Random;

public class RandomWalkers
{
  public static void main(String[] args) {
    int r = Integer.parseInt(args[0]);
    int sumOfSteps = 0;
    double averageSteps = 0;
    int trials = Integer.parseInt(args[1]);
    for(int i = 1 ; i <= trials ; i++){
      int x = 0;
      int y = 0;
      int distance = 0;
      int steps = 0;
      while(distance != r) {
        double random = Math.random();
        if(random > 0 && random < 0.25){
          x++;
          steps++;
        }
        if(random > 0.25 && random < 0.50){
          x--;
          steps++;
        }
        if(random > 0.50 && random < 0.75){
          y++;
          steps++;
        }
        if(random > 0.75 && random < 1.00){
          y--;
          steps++;
        }
        distance = Math.abs(x) + Math.abs(y);
      }
      sumOfSteps = sumOfSteps + steps;
    }
    averageSteps = ((double)sumOfSteps / trials);
    System.out.println("average number of steps = " + averageSteps);
  }
}
