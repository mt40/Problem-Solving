package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;

public class CF_227A {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int Ax = in.nextInt(), Ay = in.nextInt();
        int Bx = in.nextInt(), By = in.nextInt();
        int Cx = in.nextInt(), Cy = in.nextInt();

        double p = crossproduct(Ax, Ay, Bx, By, Cx, Cy);
        if(Math.abs(p) < 1e-7)
            out.println("TOWARDS");
        else if(p < 0)
            out.println("RIGHT");
        else
            out.println("LEFT");
    }

    // cross-product of 2 vectors AB, AC
    double crossproduct(int ax, int ay, int bx, int by, int cx, int cy) {
        return 1.0*(bx-ax) * (cy-ay) - 1.0*(by-ay) * (cx-ax);
    }
}
