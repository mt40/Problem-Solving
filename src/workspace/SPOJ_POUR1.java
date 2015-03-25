package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class SPOJ_POUR1 {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();

        int ans = -1;
        if(c % gcd(a, b) == 0)
            ans = Math.min(cal(a, b, c), cal(b, a, c));
        out.println(ans);
    }

    int gcd(int x, int y) {
        return x == 0 ? y : gcd(y % x, x);
    }

    int cal(int a, int b, int c) {
        int ans = -1;
        if(a >= c || b >= c) {
            ans = 0;
            int v1 = 0, v2 = 0;
            while(v1 != c && v2 != c) {
                if(v1 == 0) // v1 empty -> fill v1
                    v1 = a;
                else { // v1 not empty
                    if(v2 == b) // v2 full -> empty it
                        v2 = 0;
                    else { // v2 not full -> pour v1 to v2
                        int space = b - v2;
                        if(v1 >= space) {
                            v1 -= space;
                            v2 = b;
                        }
                        else {
                            v2 += v1;
                            v1 = 0;
                        }
                    }
                }
                ans++;
            }
        }
        return ans;
    }
}
