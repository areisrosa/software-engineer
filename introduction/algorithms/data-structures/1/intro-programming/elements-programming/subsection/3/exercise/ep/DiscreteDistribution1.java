public final class DiscreteDistribution1 {
    public DiscreteDistribution1() {
        // Throw an exception if this ever *is* called
        throw new AssertionError("Instantiating utility class.");
    }
    public static void main(String[] args) {
        int n = args.length;
        int[] seq = new int[n];
        for (int i = 0; i < n; i++) {
            seq[i] = Integer.parseInt(args[i]);
        }
        int m = seq[0];
        // compute total count of all sequencies
        int total = 0;
        for (int i = 1; i <= n - 1; i++) {
            total += seq[i];
        }
        // print m random indices (separated by whitespace)
        for (int j = 0; j < m; j++) {
            int sum = 0;
            int event = -1;
            // generate random integer with probability proportional to
            // sequencies
            int r = (int) (total * Math.random()); // integer in [0, total)
            for (int i = 1; i <= n - 1 && sum <= r; i++) {
                sum = sum + seq[i];
                event = i;
            }
            System.out.print(event + " ");
        }
        System.out.println();
    }
}
