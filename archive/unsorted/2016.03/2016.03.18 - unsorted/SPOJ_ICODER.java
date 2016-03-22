package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.math.BigInteger;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_ICODER {
    int inf = Integer.MAX_VALUE;
    int mod = 65536;
    BigInteger modBig = BigInteger.valueOf(mod);

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n;
        while((n = in.i()) > 0) {
            Expr expr = new Expr(1, 0);

            for (int i = 0; i < n; ++i) {
                String s = in.s();
                int v = in.i();
                if (s.equals("ADD"))
                    expr.add(v);
                else
                    expr.mul(v);
            }

            long g = gcd(expr.a, mod);
            long ans = mod / g;
            out.println(ans);
        }
    }

    long gcd(long a, long b) {
        if(a == 0) return b;
        return gcd(b % a, a);
    }

    long inv(long x) {
        return BigInteger.valueOf(x).modInverse(modBig).longValue();
    }

    // Represent aX + b
    class Expr {
        long a, b;

        public Expr(long a, long b) {
            this.a = a;
            this.b = b;
        }

        void mul(long x) {
            a *= x;
            b *= x;
            normalize();
        }

        void add(long x) {
            b += x;
            normalize();
        }

        void normalize() {
            a %= mod;
            b %= mod;
        }
    }
}