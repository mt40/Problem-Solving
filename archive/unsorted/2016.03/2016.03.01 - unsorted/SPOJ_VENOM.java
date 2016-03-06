package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_VENOM {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int H = in.i(), P = in.i(), A = in.i();
        int ans = cal(H, P, A);
        out.println(ans);
    }

    int cal(int H, int P, int A) {
        int low = 1, hi = H, rs = low;
        while(low <= hi) {
            int mid = low + (hi - low) / 2;
            long loss = f(P, A, mid);
            if(1L*H <= loss) {
                hi = mid - 1;
                rs = mid;
            }
            else
                low = mid + 1;
        }
        return rs + (rs - 1);
    }

    long f(long P, long A, long x) {
        return x*(x+1)/2*P - (x-1)*A;
    }
}