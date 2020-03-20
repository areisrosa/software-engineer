public class Kary
{
  public static long asBase3(int num, int base)
  {
    long ret = 0;
    long factor = 1;
    while (num > 0) {
      ret += num % 3 * factor;
      num /= 3;
      factor *= 10;
    }
    System.out.println(ret);
    return ret;
  }
public static long asBase2(int num, int base)
  {
    long power = 1;
    while (power <= num/2) {
      power *= 2;
      // Now power is the largest power of 2 <= n.
    }
    while (power > 0) {
      // Cast out powers of 2 in decreasing order.
      if (num < power) { System.out.print(0);             }
      else             { System.out.print(1); num -= power; }
      power /= 2;
    }
    System.out.println();
    return num;
  }

  public static void main(String[] args)
  {
    // Print Kary representation of base;
    int num = Integer.parseInt(args[0]);
    int base = Integer.parseInt(args[1]);

    if (base == 2) {
      asBase2(num,base);
    }
    else if(base == 3) {
      asBase3(num,base);
    }
  }
}
