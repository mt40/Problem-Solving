package workspace;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;
import helperClasses.ShortScanner;

public class SPOJ_BABTWR {
    double max(double...v) {double m=Double.NEGATIVE_INFINITY; for (double d:v) if(d>m)m=d; return m;}
    long max(long...v) {long m=Long.MIN_VALUE; for(long i:v)if(i>m)m=i; return m;}
    double min(double...v) {double m=Double.POSITIVE_INFINITY; for (double d:v) if(d<m)m=d; return m;}
    long min(long...v) {long m=Long.MAX_VALUE; for(long i:v)if(i<m)m=i; return m;}
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, Scanner input, PrintWriter out) {
        ShortScanner in = new ShortScanner(input);
        int n;
        while ((n = in.i()) > 0) {
            int m = 3 * n;
            Block[] a = new Block[m];
            for (int i = 0, j = 0; i < n; ++i, j += 3) {
                int x = in.i(), y = in.i(), z = in.i();
                a[j] = new Block(Math.max(x, y), Math.min(x, y), z);
                a[j + 1] = new Block(Math.max(x, z), Math.min(x, z), y);
                a[j + 2] = new Block(Math.max(y, z), Math.min(y, z), x);
            }

            out.println(cal(a, m));
        }
    }

    long cal(Block[] a, int m) {
        Arrays.sort(a); // decreasing order of base area

        long[] dp = new long[m];
        long ans = 0;
        for (int i = 0; i < m; ++i) dp[i] = a[i].z;
        for (int i = 1; i < m; ++i) {
            for (int j = 0; j < i; ++j) {
                if (a[i].x < a[j].x && a[i].y < a[j].y)
                    dp[i] = Math.max(dp[j] + a[i].z, dp[i]);
                ans = Math.max(dp[i], ans);
            }
        }
        return ans;
    }

    class Block implements Comparable<Block> {
        int x, y, z;

        public Block(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        @Override
        public int compareTo(Block o) {
            return Long.compare(1L * o.x * o.y, 1L * x * y); // decrease
        }
    }
}
