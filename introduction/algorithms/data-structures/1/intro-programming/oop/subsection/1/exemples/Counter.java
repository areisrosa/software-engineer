public class Counter 
{
  private final String name;
  private final int maxCount;
  private int count;

  public Counter(String id, int max) {

    name = id;
    maxCount = max;
  }

  public void increment() {
    
    if (count < maxCount) {
      System.out.println(count++);
    }
  }

  public int value() {
    //System.out.printf("%d", count);
    //System.out.println("\n");
    return count;
  }
  
  public String toString() {

    return name + ": " + count;
  }

  public static void main(String[] args) {

    int n = Integer.parseInt(args[0]);
    //System.out.printf("%d", n);
    //System.out.println("\n");
    int trials = Integer.parseInt(args[1]);
    //System.out.printf("%d", trials);
    //System.out.println("\n");

    Counter[] hits = new Counter[n];

    for (int i = 0; i < n; i++) {

      hits[i] = new Counter(i + "", trials);
    }

    for (int t = 0; t < trials; t++) {

      hits[StdRandom.uniform(n)].increment();
      //hits[StdRandom.uniform(n)].value();
      //hits[StdRandom.uniform(n)].toString();

    }
    
    for (int i = 0; i < n; i++) {
        
      StdOut.println(hits[i]);
    }
  }
}
