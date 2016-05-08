package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_MINMOVE {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        String s = in.sl();
        int n = s.length();
        s += s;

        int []arr = suffArray(s.toCharArray());
        int min = 0;
        for(int i = 1; i < n; ++i) {
            if(arr[i] < arr[min])
                min = i;
        }

        out.println(min);
    }

    int []suffArray(char []str) {
        int n = str.length;
        int log = (int)Math.ceil(Math.log(n) / Math.log(2));

        Entry []sf = new Entry[n]; // suffixes
        int [][]rank = new int[log][n];
        for(int i = 0; i < n; ++i) sf[i] = new Entry();

        // base case
        for(int i = 0; i < n; ++i)
            rank[0][i] = str[i] - 'a';
        for(int e = 1; e < log; ++e) {
            int half = 1 << (e - 1);
            for(int i = 0; i < n; ++i) {
                sf[i].first = rank[e - 1][i];
                sf[i].second = (i + half < n) ? rank[e - 1][i + half] : -1;
                sf[i].start = i;
            }

            Arrays.sort(sf);

            rank[e][sf[0].start] = 0;
            for(int i = 1; i < n; ++i) {
                int prev = rank[e][sf[i - 1].start];
                rank[e][sf[i].start] = (sf[i].compareTo(sf[i - 1]) == 0)
                        ? prev : prev + 1;
            }
        }

        return rank[log - 1];
    }

    class Entry implements Comparable<Entry> {
        int first, second, start;

        @Override
        public int compareTo(Entry o) {
            int rs = Integer.compare(first, o.first);
            return (rs != 0) ? rs : Integer.compare(second, o.second);
        }
    }
}