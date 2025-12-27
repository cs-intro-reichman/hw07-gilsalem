/** Draws the Koch curve and the the Koch snowflake fractal. */
public class Koch {

    public static void main(String[] args) {

        //// Uncomment the first code block to test the curve function.
        //// Uncomment the second code block to test the snowflake function.
        //// Uncomment only one block in each test, and remember to compile
        //// the class whenever you change the test.

        /*
        // Tests the curve function:
        // Gets n, x1, y1, x2, y2,
        // and draws a Koch curve of depth n from (x1,y1) to (x2,y2).
        curve(Integer.parseInt(args[0]),
              Double.parseDouble(args[1]), Double.parseDouble(args[2]), 
              Double.parseDouble(args[3]), Double.parseDouble(args[4]));
        */

        /*
        // Tests the snowflake function:
        // Gets n, and draws a Koch snowflake of n edges in the standard canvass.
        snowFlake(Integer.parseInt(args[0]));
        */
    }

    /** Gets n, x1, y1, x2, y2,
      * and draws a Koch curve of depth n from (x1,y1) to (x2,y2). */
    public static void curve(int n, double x1, double y1, double x2, double y2) {
        // Base case: if n is 0, just draw the straight line segment
        if (n == 0) {
            StdDraw.line(x1, y1, x2, y2);
            return;
        }

        // Recursive step: Divide the segment into 4 parts
        // Calculate the two internal points dividing the line into thirds
        double dx = x2 - x1;
        double dy = y2 - y1;

        double p1x = x1 + dx / 3.0;
        double p1y = y1 + dy / 3.0;

        double p2x = x1 + 2 * dx / 3.0;
        double p2y = y1 + 2 * dy / 3.0;

        // Calculate the peak of the equilateral triangle (p3)
        // Using the formula: rotated vector logic or the one provided in hints
        double p3x = (x1 + x2) / 2 - Math.sqrt(3) / 6 * (y2 - y1);
        double p3y = (y1 + y2) / 2 + Math.sqrt(3) / 6 * (x2 - x1);

        // Recursively draw the 4 segments:
        // 1. From start to first third
        curve(n - 1, x1, y1, p1x, p1y);
        // 2. From first third to the peak
        curve(n - 1, p1x, p1y, p3x, p3y);
        // 3. From peak to second third
        curve(n - 1, p3x, p3y, p2x, p2y);
        // 4. From second third to end
        curve(n - 1, p2x, p2y, x2, y2);
    }

    /** Gets n, and draws a Koch snowflake of n edges in the standard canvass. */
    public static void snowFlake(int n) {
        // A little tweak that makes the drawing look better
        StdDraw.setYscale(0, 1.1);
        StdDraw.setXscale(0, 1.1);
        // Draws a Koch snowflake of depth n

        // Define the vertices of an equilateral triangle centered in the canvas
        // Coordinates chosen to fit nicely within (0,0) to (1.1, 1.1)
        double x1 = 0.200, y1 = 0.350; // Bottom Left
        double x2 = 0.800, y2 = 0.350; // Bottom Right
        double x3 = 0.500, y3 = 0.350 + Math.sqrt(3) * 0.3; // Top Vertex (height ~0.87)

        // Draw 3 curves connecting the vertices.
        // Important: To make the snowflake points face OUTWARDS, we must traverse
        // the triangle in a specific direction (Clockwise for "left-turn" bump logic).
        
        // 1. From Bottom-Right to Bottom-Left (Bottom edge)
        curve(n, x2, y2, x1, y1);
        
        // 2. From Bottom-Left to Top (Left edge)
        curve(n, x1, y1, x3, y3);
        
        // 3. From Top to Bottom-Right (Right edge)
        curve(n, x3, y3, x2, y2);
    }
}