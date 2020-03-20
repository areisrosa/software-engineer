import java.util.*;

public final class Minesweeper {
    //
    public Minesweeper() {
        // Prevent instantiation
        // Optional: throw an exception e.g. AssertionError
        // if this ever *is* called
    }
    //
  // Implementing Fisher–Yates shuffle
  static void shuffleArray(int[] ar) {
      int index, temp;
    Random random = new Random();
    for (int i = ar.length - 1; i > 0; i--) {
      index = random.nextInt(i + 1);
      // Simple swap
      temp = ar[index];
      ar[index] = ar[i];
      ar[i] = temp;
    }
  }
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]); // mines number
        boolean[][] cells = new boolean[m][n]; // array to specify which cells
                                               // contain mines.
        int[][] neighboring = new int[m][n];   // array to count the number of 
                                               // neighboring mines.
    }
}
