package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_ABCD {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        char []a = in.c();
        char []b = new char[a.length];

        // consider block 2x2
        char prev = '0';
        for(int i = 0; i < 2*n - 1;) {
            int []f = new int[4];
            f[a[i] - 'A']++;
            f[a[i + 1] - 'A']++;
            int k = i;
            for(int j = 0; j < 4; ++j)
                if(f[j] == 0)
                    b[i++] = (char)('A' + j);
            if(prev == b[k])
                swap(b, k, k + 1);
            prev = b[k+1];
        }

        out.println(String.valueOf(b));
    }

    void swap(char []a, int i, int j) {
        char tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}