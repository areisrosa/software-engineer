
/******************************************************************************
 *  Compilation:  javac TenHellos.java
 *  Execution:    java TenHellos
 *  Dependencies: 
 *  Data files:  
 *
 *  % java TenHellos
 *  1st Hello
 *  2nd Hello
 *  3rd Hello
 *  4th Hello
 *  5th Hello
 *  6th Hello
 *  7th Hello
 *  8th Hello
 *  9th Hello
 *  10th Hello
 *
 *  
 ******************************************************************************

 This program uses a while loop for the simple, repetitive task of printing the output shown
 below. After the third line, the lines to be printed differ only in the value of the index counting
 the line printed, so we define a variable i to contain that index. After initializing the value of
 i to 4, we enter into a while loop where we use the value of i in the System.out.println()
 statement and increment it each time through the loop. After printing 10th Hello, the value
 of i becomes 11 and the loop terminates.

*/

public class TenHellos {

  public static void main(String[] args) {
  
    // Print 10 Hellos
    System.out.println("1st Hello");
    System.out.println("2st Hello");
    System.out.println("3st Hello");

    int i = 4;

    while (i <= 10) {
      // Print the ith Hello.
      System.out.println(i + "th Hello");
      i = i + 1;

    }    
  }
}
