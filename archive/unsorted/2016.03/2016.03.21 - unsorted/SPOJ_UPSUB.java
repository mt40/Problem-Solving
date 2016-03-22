package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_UPSUB {
    int inf = Integer.MAX_VALUE;
    final char bound = '~';

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        a = in.c();
        int n = a.length;

        Entry []lis = new Entry[n + 1]; // longest increasing subsequence
        for(int i = 1; i <= n; ++i)
            lis[i] = new Entry(bound, null);
        mark = new int[n];

        int maxLen = 1;
        for(int i = 0; i < n; ++i) {
            int pos = find(lis, a[i]);
            lis[pos] = new Entry(a[i], lis[pos-1]);
            maxLen = Math.max(pos, maxLen);
            mark[i] = pos;
        }

        listAnswer = new ArrayList<>();
        recover(n - 1, maxLen, bound, "");
        Collections.sort(listAnswer);

        for(String ans : listAnswer)
            out.println(ans);
    }

    List<String> listAnswer;
    char []a;
    int []mark;
    void recover(int i, int len, char cur, String s) {
        if(i == -1) {
            if(len == 0) listAnswer.add(s);
            return;
        }
        if(mark[i] == len && a[i] <= cur)
            recover(i - 1, len - 1, a[i], a[i] + s);
        recover(i - 1, len, cur, s);
    }

    int find(Entry []lis, char key) {
        int low = 1, hi = lis.length - 1, rs = hi;
        while(low <= hi) {
            int mid = low + (hi - low) / 2;
            if(lis[mid].key > key) {
                rs = mid;
                hi = mid - 1;
            }
            else low = mid + 1;
        }
        return rs;
    }

    class Entry {
        char key;
        Entry prev;

        public Entry(char key, Entry prev) {
            this.key = key;
            this.prev = prev;
        }
    }
}