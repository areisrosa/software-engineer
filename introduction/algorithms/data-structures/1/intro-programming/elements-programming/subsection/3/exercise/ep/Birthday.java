public final class Birthday {
    public Birthday() {
        // Throw an exception if this ever *is* called
        throw new AssertionError("Instantiating utility class.");
    }
    /*
     *
     * */
    private static final int TEST = 10000;
    /*
     *
     * */
    private static final double FACT = 0.50;
    //
    public static void main(String[] args) {
        int days   =  Integer.parseInt(args[0]); // number of days
        int trials =  Integer.parseInt(args[1]);
        boolean[] hasBirthday = new boolean[trials];
        int[] people = new int[days + 2]; // total number of people
        int i = 0;
        int d = 0;
        double sum = 0.0;
        double fraction = 0.0;
        // How many people must enter a room until two share a birthday.
        int shareBirthday = (int) Math.sqrt(Math.PI * days / 2); 
        while (true && i < shareBirthday) {
            i++;
            people[i] = i;
            System.out.println(i + "\t" + d + "\t" + fraction);
            d = (int) (Math.round(TEST * Math.random())); 
            if (hasBirthday[d]) {
                break; // two people with sama birthday, so break out of loop
            }
            hasBirthday[d] = true; // update array 
            for (int j = 1; j <= people[i]; j++) {
                sum += d;
            }
            if (fraction >= FACT) {
                break;
            }
            fraction = (sum / trials);
        }
    }
}
