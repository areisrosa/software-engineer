public class GreatCircle
{
    public static void main(String[] args)
    {
        double x1       = Double.parseDouble(args[0]);
        double x2       = Double.parseDouble(args[1]);
        double y1       = Double.parseDouble(args[2]);
        double y2       = Double.parseDouble(args[3]);

        /*********************************************
         * Compute using Haversine formula
        *******************************************/
        double a =
            Math.pow(Math.sin((Math.toRadians(x2)-Math.toRadians(x1))/2), 2) +
            Math.cos(Math.toRadians(x1)) * Math.cos(Math.toRadians(x2)) *
            Math.pow(Math.sin((Math.toRadians(y2)-Math.toRadians(y1))/2), 2);
        //
        double a1 = Math.sqrt(a);
        // great circle distance in radians
        double distance = 2 * 6371.0 * Math.asin(Math.min(1, a1));

        System.out.println(distance + " kilometers");
    }
}
