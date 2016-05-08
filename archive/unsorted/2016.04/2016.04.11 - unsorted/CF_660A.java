package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import helperClasses.FastScanner;
import helperClasses.Util;

public class CF_660A {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        int []a = in.arr(n);

        List<Integer> list = new ArrayList<>(n);
        list.add(a[0]);
        int prev = a[0];
        for(int i = 1; i < n; ++i) {
            if(!isCoprime(prev, a[i]))
                list.add(1);
            list.add(a[i]);
            prev = a[i];
        }

        out.println(list.size() - n);
        for(int li : list)
            out.print(li + " ");
        out.println();
    }

    boolean isCoprime(int a, int b) {
        return gcd(a, b) == 1;
    }

    int gcd(int a, int b) {
        if(a == 0)
            return b;
        return gcd(b % a, a);
    }
}