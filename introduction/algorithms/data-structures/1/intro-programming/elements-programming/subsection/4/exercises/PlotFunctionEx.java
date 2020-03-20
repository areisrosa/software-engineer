/******************************************************************************
 *  Compilation:  javac PlotFunctionEx.java 
 *  Execution:    java PlotFunctionEx n
 *  Dependencies: StdDraw.java
 *
 *  Plots the function y = sin(4x) + sin(20x) between x = 0 and x = pi
 *  by drawing n line segments.
 *
 ******************************************************************************/
// Plotting a function graph. PlotFunctionEx.java plots the function y = sin(4x) +
// sin(20x) in the interval (0, π). There are an infinite number of points in the
// interval, so we have to make do with evaluating the function at a finite number
// of points within the interval. We sample the function by choosing a set of
// x-values, then computing y-values by evaluating the function at each x-value.
// Plotting the function by connecting successive points with lines produces what
// is known as a piecewise linear approximation. 

public class PlotFunctionEx {
    public static void main(String[] args) {

        // number of line segments to plot
        int n = Integer.parseInt(args[0]);

        // the function y = sin(4x) + sin(20x), sampled at n+1 points
        // between x = 0 and x = pi
        double[] x = new double[n+1];
        double[] y = new double[n+1];
        for (int i = 0; i <= n; i++) {
            x[i] = Math.PI * i / n;
            y[i] = Math.sin(4*x[i]) + Math.sin(20*x[i]);
        }

        // rescale the coordinate system
        StdDraw.setXscale(0, Math.PI);
        StdDraw.setYscale(-2.0, +2.0);

        // plot the approximation to the function
        for (int i = 0; i < n; i++) {
            StdDraw.line(x[i], y[i], x[i+1], y[i+1]);
        }
    }
}


