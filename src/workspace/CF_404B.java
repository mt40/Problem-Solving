package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class CF_404B {
    int[] readArr(int n,Scanner in){int []a=new int[n]; for(int i=0; i<n; ++i) a[i]=in.nextInt();return a;}
    class ShortScanner{Scanner in;ShortScanner(Scanner in){this.in=in;}int i(){return in.nextInt();}long l(){return in.nextLong();}double d(){return in.nextDouble();}String s(){return in.next();}}

    public void solve(int testNumber, Scanner input, PrintWriter out) {
        ShortScanner in = new ShortScanner(input);
        double a = in.d(), d = in.d();
        int n = in.i();

        double ran = 0;
        for(int i = 0; i < n; ++i) {
            ran += d;
            long k = (int)(ran / a);
            long t = k % 4;
            double dif = ran - k*a;
            if(t == 0)
                out.printf("%.10f %.10f\n", round(dif), 0.0);
            else if(t == 1)
                out.printf("%.10f %.10f\n", a, round(dif));
            else if(t == 2)
                out.printf("%.10f %.10f\n", round(a-dif), a);
            else
                out.printf("%.10f %.10f\n", 0.0, round(a-dif));
        }
    }

    double round(double d) {
        return Math.round(d * 10000d) / 10000d;
    }
}
