package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_ACS {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = 1234 * 5678;
        int []c = new int[n], r = new int[n];
        int []col = new int[5679], row = new int[1235];
        for(int i = 1; i <= 5678; ++i) {
            c[i] = i;
            col[i] = i;
        }
        for(int i = 1; i <= 1234; ++i) {
            r[5678*(i-1)+1] = i;
            row[i] = 5678*(i-1)+1;
        }

        while(true) {
            char t;
            try {
                t = in.s().charAt(0);
            } catch(Exception e) {return;}
            if(t == 'R') {
                int x = in.i(), y = in.i();
                int i = row[x], j = row[y];
                row[x] = j; r[j] = x;
                row[y] = i; r[i] = y;
            }
            else if(t == 'C') {
                int x = in.i(), y = in.i();
                int i = col[x], j = col[y];
                col[x] = j; c[j] = x;
                col[y] = i; c[i] = y;
            }
            else if(t == 'Q') {
                int x = in.i(), y = in.i();
                int i = row[x], j = col[y];
                out.println(j + (i - 1));
            }
            else if(t == 'W') {
                int z = in.i();
                int i = (z-1) / 5678 * 5678 + 1, j = z % 5678;
                if(j == 0) j = 5678;
                out.println(r[i] + " " + c[j]);
            }
        }
    }
}