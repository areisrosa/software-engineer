
/******************************************************************************
 *  Compilation:  javac TenHelloWorlds.java
 *  Execution:    java TenHelloWorlds yourname
 *
 *  Prints "Hello, Worlds ten times.
 *
 *  % java TenHelloWorlds
 *  Hello, Worlds
 *  Hello, Worlds
 *  Hello, Worlds
 *  Hello, Worlds
 *  Hello, Worlds
 *  Hello, Worlds
 *  Hello, Worlds
 *  Hello, Worlds
 *  Hello, Worlds
 *  Hello, Worlds
 *
*******************************************************************************/

public class TenHelloWorlds {

  public static void main(String[] args) {

    for ( int i = 0; i < 10; ++i) {
      System.out.println("Hello, Worlds");
      System.out.print("\n");
    }
  }
}
