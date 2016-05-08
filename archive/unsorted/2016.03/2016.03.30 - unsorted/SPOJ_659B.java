package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_659B {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i(), m = in.i();
        ArrayList<Entry>[] set = new ArrayList[m + 1];
        for(int i = 1; i <= m; ++i)
            set[i] = new ArrayList<>();
        for(int i = 0; i < n; ++i) {
            String name = in.s();
            int region = in.i(), score = in.i();
            set[region].add(new Entry(name, region, score));
        }

        for(int i = 1; i <= m; ++i) {
            ArrayList<Entry> list = set[i];
            Collections.sort(list);
            Entry first = list.get(0);
            Entry second = list.get(1);
            if(list.size() > 2) {
                Entry third = list.get(2);
                if(second.score == third.score) {
                    out.println("?");
                    continue;
                }
            }
            out.printf("%s %s\n", first.name, second.name);
        }
    }

    class Entry implements Comparable<Entry> {
        String name;
        int idx, score;

        public Entry(String name, int idx, int score) {
            this.name = name;
            this.idx = idx;
            this.score = score;
        }

        @Override
        public int compareTo(Entry o) {
            return Integer.compare(o.score, score);
        }
    }
}