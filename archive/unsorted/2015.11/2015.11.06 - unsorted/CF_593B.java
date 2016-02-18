package workspace;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.io.PrintWriter;

public class CF_593B {
    double eps = 1e-10;
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        Info.x1 = in.nextInt() + eps;
        Info.x2 = in.nextInt() - eps;
        Line []a = new Line[n];
        for(int i = 0; i < n; ++i) {
            a[i] = new Line(i, in.nextInt(), in.nextInt());
        }
        Line []b = a.clone();
        Arrays.sort(a, new Comparator<Line>() {
            @Override
            public int compare(Line o1, Line o2) {
                return Double.compare(Info.x1 * o1.a + o1.b, Info.x1 * o2.a + o2.b);
            }
        });
        Arrays.sort(b, new Comparator<Line>() {
            @Override
            public int compare(Line o1, Line o2) {
                return Double.compare(Info.x2 * o1.a + o1.b, Info.x2 * o2.a + o2.b);
            }
        });

        boolean ans = check(a, b, n);
        out.println(ans ? "NO" : "YES");
    }

    boolean check(Line []a, Line []b, int n) {
        for(int i = 0; i < n; ++i)
            if(a[i].a != b[i].a || a[i].b != b[i].b)
                return false;
        return true;
    }

    class Line {
        int a, b, id;
        public Line(int id, int a, int b) {
            this.id = id;
            this.a = a;
            this.b = b;
        }
    }
}

class Info {
    public static double x1, x2;
}
