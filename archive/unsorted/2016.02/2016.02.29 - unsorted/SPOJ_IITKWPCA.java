package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.HashSet;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_IITKWPCA {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        String s = in.sl();
        String []parts = s.split("\\s+");

        HashSet<String> set = new HashSet<>();
        for(String p : parts) {
            if(p.length() == 0) continue;
            set.add(reverse(p));
        }

        out.println(set.size());
    }

    String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}