package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_PLD {
    int inf = Integer.MAX_VALUE;
    long p = 53, mod = 1000000007, inv_p = 56603774;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int k = in.i();
        char []a = in.c();
        int n = a.length;

        if(k == 0 || k == 1) {
            out.println((k == 0) ? 0 : n);
            return;
        }

        long ans = 0, left = 0, right = 0, mul = 1;
        for(int i = 0; i < k/2; ++i) {
            left = (left + (num(a[i]) * mul) % mod) % mod;
            right = (right + (num(a[k - 1 - i]) * mul) % mod) % mod;
            mul = (mul * p) % mod;
        }
        if(left == right) ans++;

        long power = modPow(p, k/2 - 1); // p^(k/2 - 1)
        int rightEnd = k, leftEnd = 0;
        for(; rightEnd < n; ++rightEnd, ++leftEnd) {
            int removeLeft = num(a[leftEnd]), addLeft = num(a[leftEnd + k/2]);
            int removeRight = num(a[rightEnd - k/2]), addRight = num(a[rightEnd]);

            left = (left - removeLeft + mod) % mod;
            left = (left * inv_p) % mod;
            left = (left + (addLeft*power) % mod) % mod;

            right = (right - ((removeRight*power) % mod) + mod) % mod;
            right = (right * p) % mod;
            right = (right + addRight) % mod;

            if(left == right) ans++;
        }

        out.println(ans);
    }

    long modPow(long base, int e) {
        long rs = 1;
        while(e > 0) {
            if((e & 1) > 0)
                rs = (rs * base) % mod;
            base = (base * base) % mod;
            e >>= 1;
        }
        return rs;
    }

    int num(char c) {
        return c - 'a' + 1;
    }
}