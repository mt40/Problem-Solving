package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;

import helperClasses.FastScanner;
import helperClasses.Util;

public class CF_632C {
    int inf = Integer.MAX_VALUE;
    int maxLen = 50;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        Entry []a = new Entry[n];
        for(int i = 0; i < n; ++i)
            a[i] = new Entry(in.s(), maxLen);

        Arrays.sort(a, cprt);

        StringBuilder sb = new StringBuilder();
        for(Entry ai : a)
            sb.append(ai.s);

        out.println(sb.toString());
    }

    Comparator<Entry> cprt = (o1, o2) -> {
        String o12 = o1.s + o2.s;
        String o21 = o2.s + o1.s;
        return o12.compareTo(o21);
    };

    class Entry {
        String s, padded;

        Entry(String src, int padLen) {
            s = src;
//            char last = s.charAt(s.length() - 1);
//            StringBuilder sb = new StringBuilder(src);
//
//            int dif = padLen - s.length();
//            while(dif-- > 0)
//                sb.append(last);
//            padded = sb.toString();
        }
    }
}