package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;

public class SPOJ_TETRA {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int wx, wy, wz, xy, xz, yz;
        wx = in.nextInt();
        wy = in.nextInt();
        wz = in.nextInt();
        xy = in.nextInt();
        xz = in.nextInt();
        yz = in.nextInt();

        int []e = {wx, wy, xy,
                wy, wz, yz,
                wx, wz, xz,
                xy, yz, xz};
        double S = 0;
        for(int i = 0; i + 3 < e.length; i += 3) {
            int a = e[i], b = e[i + 1], c = e[i + 2];
            double p = (a + b + c) * 1.0 / 2;
            double s = Math.sqrt(p * (p - a) * (p - b) * (p - c));
            S += s;
        }

    }
}
