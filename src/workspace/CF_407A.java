package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

//TODO!
public class CF_407A {
    double pi = Math.PI;
    double eps = 0.000000000001;
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int a = in.nextInt();
        int b = in.nextInt();

        if(a != 1 && b != 1) {
            for(int i = 1; i < a; ++i) {
                double h2 = a*a - i*i;
                double xx = h2/i;
                if(xx % 1 == 0) {
                    double yy = b*b*1.0 / (xx*xx + 1);
                    double h1 = Math.sqrt(yy);
                    if(h1 % 1 == 0) {
                        out.println("YES");
                        out.printf("-%d %d\n", xx * h1, h1);
                        out.printf("%d %d\n", 0, 0);
                        out.printf("%d %d\n", i, h2);
                        return;
                    }
                }
            }
        }

        out.println("NO");
    }
}
