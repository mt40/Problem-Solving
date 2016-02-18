package workspace;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class CF_382C {
    int[] readArr(int n, Scanner in) { int []a = new int[n]; for(int i = 0; i < n; ++i) a[i] = in.nextInt(); return a; }
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int []a = readArr(n, in);

        if(n == 1) {
            out.println(-1);
        }
        else {
            int ans = 0;
            Arrays.sort(a);
            boolean isValid = check(a, n);
            if(isValid && isConst(a, n)) {
                out.println("1\n" + a[0]);
            }
            else if(isValid) {
                int left = a[0] - (a[1] - a[0]), right = a[n - 1] + (a[n - 1] - a[n - 2]);
                if((a[1] - a[0]) % 2 == 0 && n == 2)
                    out.printf("3\n%d %d %d\n", left, a[0] + (a[1] - a[0])/2, right);
                else
                    out.printf("2\n%d %d\n", left, right);
            }
            else {
                int step = Math.min(a[1] - a[0], a[2] - a[1]), x = 0;
                boolean added = false;
                for(int i = 0; i < n - 1; ++i) {
                    if(a[i + 1] - a[i] != step) {
                        x = a[i] + step;
                        if(added || x + step != a[i + 1]) {
                            out.println(0); return;
                        }
                        added = true;
                    }
                }
                out.println("1\n" + x);
            }
        }
    }

    boolean check(int []a, int n) {
        if(n <= 2) return true;
        int step = a[1] - a[0];
        for(int i = 0; i < n - 1; ++i) {
            if(a[i + 1] - a[i] != step) return false;
        }
        return true;
    }

    boolean isConst(int []a, int n) {
        for(int i = 0; i < n - 1; ++i)
            if(a[i] != a[i + 1]) return false;
        return true;
    }
}
