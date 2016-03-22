package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_PARADOX {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n;
        while((n = in.i()) > 0) {
            claims = new Claim[n+1];
            for(int i = 1; i <= n; ++i)
                claims[i] = new Claim(in.i(), in.b());

            boolean ans = false;
            table = new boolean[n + 1];
            vst = new boolean[n+1];
            real_vst = new boolean[n + 1];
            for(int i = 1; i <= n; ++i) {
                if(vst[i]) continue;

                table[i] = true;
                boolean ans1 = dfs(i);

                revert(); // reset
                table[i] = false;
                boolean ans2 = dfs(i);

                ans = ans1 & ans2;
                if(ans) break; // paradox detected! no need to go further
                apply();
            }

            out.println(ans ? "PARADOX" : "NOT PARADOX");
        }
    }

    boolean [] vst, real_vst, table; // truth table
    Claim []claims;
    boolean dfs(int u) {
        if(vst[u]) return false;
        vst[u] = true;
        Claim cl = claims[u];
        boolean val = cl.val;
        if(!table[u]) val = !val;

        if(vst[cl.v]) {
            if(table[cl.v] != val)
                return true; // paradox!
        }
        else {
            table[cl.v] = val;
        }

        return dfs(cl.v);
    }

    void revert() {
        System.arraycopy(real_vst, 0, vst, 0, vst.length);
    }

    void apply() {
        System.arraycopy(vst, 0, real_vst, 0, vst.length);
    }

    class Claim {
        int v;
        boolean val;

        public Claim(int v, boolean val) {
            this.v = v;
            this.val = val;
        }
    }
}