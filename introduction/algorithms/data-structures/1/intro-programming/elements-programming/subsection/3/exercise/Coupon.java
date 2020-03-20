public class Coupon {
    public static void main(String[] args) {
        int M = Integer.parseInt(args[0]);
        int cards = 0;
        int distinc = 0;

        boolean[] found = new boolean[M];
        while (distinc < M) {
            int r = (int) (Math.random() * M);
            cards++;
            if(!found[r]) {
                distinc++;
                found[r] = true;
            }
        }
        System.out.println(cards);
    }
}
