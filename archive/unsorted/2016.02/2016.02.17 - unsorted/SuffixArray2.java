package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SuffixArray2 {
    int inf = Integer.MAX_VALUE;

    /**
     * Retry after a long time :)
     */
    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        char []a = in.c();

        int []suffix_array = suffixArr(a);
        System.out.print("Suffix array: ");
        out.println(Arrays.toString(suffix_array).replaceAll("[\\[\\],]", ""));
    }

    int[] suffixArr(char []src) {
        int n = src.length;
        int log = (int)Math.ceil(Math.log(n)/Math.log(2));

        Entry []sf = new Entry[n]; // suffixes
        for(int i = 0; i < n; ++i) sf[i] = new Entry();

        // rank[i,j] = rank of suffix starting at j, length 2^i
        int [][]rank = new int[log][n];
        // base case
        for(int i = 0; i < n; ++i)
            rank[0][i] = src[i] - 'a';

        for(int j = 1; j < log; ++j) {
            int half = 1 << (j-1);
            // Merge 2 smaller suffixes
            for(int i = 0; i < n; ++i) {
                sf[i].lr[0] = rank[j - 1][i];
                sf[i].lr[1] = (i + half < n) ? rank[j - 1][i + half] : -1;
                sf[i].start = i;
            }
            // Sort
            Arrays.sort(sf, cpr);
            // Assign new rank
            // if sf[i] = sf[i-1] then rank of sf[i] = rank of sf[i-1]
            for(int i = 0; i < n; ++i) {
                if(i == 0)
                    rank[j][sf[i].start] = 0;
                else {
                    int prev = rank[j][sf[i - 1].start];
                    rank[j][sf[i].start] = sf[i].equals(sf[i - 1]) ? prev : prev + 1;
                }
            }
        }

        return rank[log - 1];
    }

    Comparator<Entry> cpr = (o1, o2)-> {
        int t = Integer.compare(o1.lr[0], o2.lr[0]);
        return (t == 0) ? Integer.compare(o1.lr[1], o2.lr[1]) : t;
    };

    static class Entry {
        int []lr = {-1,-1}; // left half and right half
        int start; // starting position

        boolean equals(Entry other) {
            return lr[0] == other.lr[0] && lr[1] == other.lr[1];
        }

        @Override
        public String toString() {
            return "{" +
                    "lr=" + Arrays.toString(lr) +
                    ", " + start +
                    '}';
        }
    }
}