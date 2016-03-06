package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import helperClasses.FastScanner;
import helperClasses.Util;

public class CF_631D {
    int inf = Integer.MAX_VALUE;

    /**
     * This will not pass the time limit. Instead of calling the KMP function for each match
     * we have to use the fail function somehow...
     * src: http://codeforces.com/blog/entry/43551?#comment-282446
     */
    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i(), m = in.i();
        List<Group> b = createList(in, n);
        List<Group> a = createList(in, m);
        n = a.size(); m = b.size();

        long ans = 0;
        if(n == 1) {
            Group g = a.get(0);
            for(Group bi : b) {
                if(bi.c == g.c && bi.cnt >= g.cnt)
                    ans += bi.cnt - g.cnt + 1;
            }
        }
        else {
            int []f = preprocess(a, n);
            int matchAt = 0;
            do {
                matchAt = KMP(f, a, b, n, m, matchAt);
                if (matchAt >= 0) {
                    ans++;
                    int skip = f[n - 1];
                    if(matchAt - skip >= 0) // cannot skip
                        matchAt -= skip;
                }
            } while(matchAt >= 0 && matchAt < m - 1);
        }
        out.println(ans);
    }

    int KMP(int []f, List<Group> pat, List<Group> text, int n, int m, int start) {
        int i = 0, j = start, match_len = 0;
        while(i < n && j < m) {
            if(isMatch(pat, text, i, j)) {
                i++; j++; match_len++;
                if(match_len == n) {
                    return j;
                }
            }
            else if(match_len >= 1) { // can be skipped
                match_len = f[i-1];
                i = f[i - 1];
            }
            else {
                j++;
                i = match_len = 0;
            }
        }
        return -1;
    }

    boolean isMatch(List<Group> pat, List<Group> text, int i, int j) {
        if(pat.get(i).c != text.get(j).c) return false;
        if(i == 0 || i == pat.size() - 1)
            return pat.get(i).cnt <= text.get(j).cnt;
        return pat.get(i).cnt == text.get(j).cnt;
    }

    int []preprocess(List<Group> pat, int n) {
        int []f = new int[pat.size()];
        for(int i = 2; i < n; ++i) {
            if(pat.get(i).c == pat.get(f[i-1]).c)
                f[i] = f[i-1] + 1;
        }

        return f;
    }

    List<Group> createList(FastScanner in, int n) {
        ArrayList<Group> a = new ArrayList<>();
        for(int i = 0, idx = 0; i < n; ++i) {
            Group g = read(in.s());
            if(a.size() > 0 && a.get(idx-1).c == g.c)
                a.get(idx-1).merge(g);
            else {
                a.add(g);
                idx++;
            }
        }
        return a;
    }

    Group read(String s) {
        String []parts = s.split("-");
        return new Group(Integer.valueOf(parts[0]), parts[1].charAt(0));
    }

    class Group {
        long cnt; // be careful :)
        char c;

        public Group(int cnt, char c) {
            this.cnt = cnt;
            this.c = c;
        }

        void merge(Group g) {
            cnt += g.cnt;
        }
    }
}