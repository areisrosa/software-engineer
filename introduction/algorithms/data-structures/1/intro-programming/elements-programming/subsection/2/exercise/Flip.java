/******************************************************************************
 *  Compilation:  javac Flip.java
 *  Execution:    java Flip
 *  Dependencies: 
 *  Data files:  
 *
 *  % java Flip
 *  Heads or Tails
 *  
 *  
 ******************************************************************************/



/* This program uses Math.random() to simulate a fair coin flip. Each time you run it, it prints
   either Heads or Tails. A sequence of flips will have many of the same properties as a sequence
   that you would get by flipping a fair coin, but it is not a truly random sequence.
*/

public class Flip {

  public static void main(String[] args) { // Simulate a fair coin flip.
  
    if (Math.random() < 0.5) 
      System.out.println("Heads");
    else
      System.out.println("Tails");
  }
}

