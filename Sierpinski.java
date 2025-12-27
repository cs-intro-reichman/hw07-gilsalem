/** Draws the Sierpinski Triangle fractal. */
public class Sierpinski {
    
    public static void main(String[] args) {
        if (args.length > 0) {
            sierpinski(Integer.parseInt(args[0]));
        } else {
            System.out.println("Please enter the recursion depth as an argument.");
        }
    }
    
    // Draws a Sierpinski triangle of depth n on the standard canvass.
    public static void sierpinski(int n) {
        double x1 = 0.0, y1 = 0.0;
        double x2 = 1.0, y2 = 0.0;
        double x3 = 0.5, y3 = Math.sqrt(3) / 2; 
        double[] xArr = {x1, x2, x3};
        double[] yArr = {y1, y2, y3};
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledPolygon(xArr, yArr);
        sierpinski(n, x1, x2, x3, y1, y2, y3);
    }
    
    private static void sierpinski(int n, double x1, double x2, double x3, 
                                          double y1, double y2, double y3) {
        
        if (n <= 0) {
            return;
        }

        double m12x = (x1 + x2) / 2;
        double m12y = (y1 + y2) / 2;
        
        double m23x = (x2 + x3) / 2;
        double m23y = (y2 + y3) / 2;
        
        double m31x = (x3 + x1) / 2;
        double m31y = (y3 + y1) / 2;

        StdDraw.setPenColor(StdDraw.WHITE);
        double[] xInv = {m12x, m23x, m31x};
        double[] yInv = {m12y, m23y, m31y};
        StdDraw.filledPolygon(xInv, yInv);
        sierpinski(n - 1, x1, m12x, m31x, y1, m12y, m31y);
        
        sierpinski(n - 1, m12x, x2, m23x, m12y, y2, m23y);
        
        sierpinski(n - 1, m31x, m23x, x3, m31y, m23y, y3);
    }
}