package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class CF_321A {
    class ShortScanner{Scanner in;ShortScanner(Scanner in){this.in=in;}int i(){return in.nextInt();}long l(){return in.nextLong();}double d(){return in.nextDouble();}String s(){return in.next();}char[] c(){return in.next().toCharArray();}int[] readArr(int n){int []a=new int[n]; for(int i=0; i<n; ++i) a[i]=in.nextInt();return a;}}
    double max(double...v) {double m=Double.NEGATIVE_INFINITY; for (double d:v) if(d>m)m=d; return m;}
    long max(long...v) {long m=Long.MIN_VALUE; for(long i:v)if(i>m)m=i; return m;}

    int inf = Integer.MAX_VALUE;
    public void solve(int testNumber, Scanner input, PrintWriter out) {
        ShortScanner in = new ShortScanner(input);
        int x = in.i(), y = in.i();
        char []c = in.c();

        int dx = 0, dy = 0, n = c.length;
        Pair []d = new Pair[n];
        for(int i = 0; i < n; ++i) {
            Pair p = change(c[i]);
            dx += p.a; dy += p.b;
            d[i] = new Pair(dx, dy);
        }

        if(x == 0 && y == 0) {
            out.println("Yes");
        }
        else {
            for(int i = 0; i < n; ++i) {
                int w = x - d[i].a, z = y - d[i].b;
                if(w == 0 && z == 0) {
                    out.println("Yes");
                    return;
                }
                int tx = -2, ty = -2;
                if(dx == 0 && w == 0) tx = inf; //ok
                if(dx != 0) tx = w / dx;
                if(dy == 0 && z == 0) ty = inf;
                if(dy != 0) ty = z / dy;
                if(tx < 0 || ty < 0) continue;
                if(dx * tx == w && dy * ty == z
                        && (tx == ty || tx == inf || ty == inf)) {
                    out.println("Yes");
                    return;
                }
            }
            out.println("No");
        }

    }

    Pair change(char c) {
        if(c == 'L') return new Pair(-1, 0);
        if(c == 'R') return new Pair(1, 0);
        if(c == 'U') return new Pair(0, 1);
        return new Pair(0, -1);
    }

    class Pair {
        int a, b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}
