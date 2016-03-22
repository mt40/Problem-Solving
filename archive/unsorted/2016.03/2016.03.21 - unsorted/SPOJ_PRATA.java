package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_PRATA {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i(), chefs = in.i();
        int []a = in.arr(chefs);

        int maxR = Util.max(a), maxTime = n*(maxR*n + maxR)/2;

        int []pratas = new int[maxTime+1];
        for(int i = 0; i < chefs; ++i) {
            int cul = 0;
            for(int j = 1; j <= n; ++j) {
                cul += j * a[i];
                pratas[cul]++;
            }
        }

        int prataMade = 0;
        for(int i = 1; i <= maxTime; ++i) {
            prataMade += pratas[i];
            if(prataMade >= n) {
                out.println(i);
                return;
            }
        }
    }
}