/******************************************************************************
 *  Compilation:  javac PlotFilter.java
 *  Execution:    java PlotFilter < input.txt
 *  Dependencies: StdDraw.java StdIn.java
 *  
 *  % java PlotFilter < USA.txt (sequence of points coordinates (13,509 cities))
 *
 *  Data files: https://introcs.cs.princeton.edu/java/15inout/USA.txt
 *
 ******************************************************************************/

// Filtering data to a standard drawing. PlotFilter.java reads a sequence of
// points defined by (x, y) coordinates from standard input and draws a spot at
// each point. It adopts the convention that the first four numbers on standard
// input specify the bounding box, so that it can scale the plot. 

public class PlotFilter
{
    public static void main(String[] args)
    {
        // read in bounding box and rescale
        double xmin = StdIn.readDouble();
        double ymin = StdIn.readDouble();
        double xmax = StdIn.readDouble();
        double ymax = StdIn.readDouble();
        StdDraw.setXscale(xmin, xmax);
        StdDraw.setYscale(ymin, ymax);
        
        // for bigger points
        StdDraw.setPenRadius(0.005);

        // plot points, one at a time
        while (!StdIn.isEmpty())
        {
            double x = StdIn.readDouble();
            double y = StdIn.readDouble();
            StdDraw.point(x,y);
        }
        // display all of the points now
        StdDraw.show();
    }
}
