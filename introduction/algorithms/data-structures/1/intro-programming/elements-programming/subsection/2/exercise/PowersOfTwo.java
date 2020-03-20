
/******************************************************************************
 *  Compilation:  PowersOfTwo.java
 *  Execution:    java PowersOfTwo <power>
 *  Dependencies: 
 *  Data files:  
 *
 *  % java PowersOfTwo 5
 *  
 ******************************************************************************

 This program takes an integer command-line argument n and prints a table of the powers of 2
 that are less than or equal to 2 n. Each time through the loop, it increments the value of i and
 doubles the value of power. We show only the first three and the last three lines of the table; the
 program prints n+1 lines.
 */

public class PowersOfTwo {

  public static void main(String[] args) {
  
    // Print the first n power of 2.
    int n = Integer.parseInt(args[0]);
    int power = 1;
    int i = 0;

    System.out.println("i" + "  " + " power");
    while (i <= n) {
      // Print ith power of 2.
      System.out.println(i + " | " + power);
      power = 2 * power;
      i = i + 1;
    }
  }
}
