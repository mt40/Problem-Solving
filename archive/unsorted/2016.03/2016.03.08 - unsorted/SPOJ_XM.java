package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import helperClasses.FastScanner;
import helperClasses.Util;

/**
 * This is a very difficult problem. I have to get some help.
 * Help src: https://www.hackerearth.com/notes/gaussian-elimination/
 */
public class SPOJ_XM {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        long []a = in.arrl(n);

        Queue<Long>[]lvl = new Queue[64];
        for(int i = 0; i < lvl.length; ++i) lvl[i] = new LinkedList<>();
        for(long ai : a)
            lvl[highestBit(ai)].add(ai);

        long []lvlMax = new long[64];
        for(int i = 63; i >= 0; --i) {
            if(!lvl[i].isEmpty()) {
                lvlMax[i] = lvl[i].poll();
                while(!lvl[i].isEmpty()) {
                    long x = lvl[i].poll();
                    x ^= lvlMax[i];
                    if(x > 0)
                        lvl[highestBit(x)].add(x);
                }
            }
        }

        long ans = 0;
        for(int i = 63; i >= 0; --i)
            ans = Math.max(ans ^ lvlMax[i], ans);

        out.println(ans);
    }

    int highestBit(long x) {
        return 64 - Long.numberOfLeadingZeros(x) - 1;
    }
}