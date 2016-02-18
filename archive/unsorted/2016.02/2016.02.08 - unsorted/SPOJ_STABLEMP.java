package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.*;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_STABLEMP {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        int [][]m = new int[n][n], w = new int[n][n];
        for(int i = 0; i < n; ++i) {
            in.i();
            for (int j = 0; j < n; ++j)
                w[i][j] = in.i()-1;
        }
        for(int i = 0; i < n; ++i) {
            in.i();
            for (int j = 0; j < n; ++j)
                m[i][j] = in.i()-1;
        }

        List<Couple> ans = cal(m, w, n);
        for(Couple c : ans)
            out.printf("%d %d\n", c.husb + 1, c.wife + 1);
    }

    // The Gale-Shapley algorithm
    List<Couple> cal(int [][]m, int [][]w, int n) {
        TreeSet<Integer> mfree = new TreeSet<>();
        int []m_w = new int[n], w_m = new int[n];
        boolean []wfree = new boolean[n];

        Arrays.fill(m_w, -1);
        Arrays.fill(w_m, -1);
        Arrays.fill(wfree, true);
        for(int i = 0; i < n; ++i)
            mfree.add(i);

        BitSet []mb = new BitSet[n];
        for(int i = 0; i < n; ++i)
            mb[i] = new BitSet(n);

        while (!mfree.isEmpty() && !proposedAll(mb, mfree.first(), n)) {
            int mi = mfree.pollFirst();
            int wi = -1;
            // find highest ranked women that is not proposed by mi
            for (int i = 0; i < n; ++i) {
                if (!mb[mi].get(m[mi][i])) {
                    wi = m[mi][i];
                    break;
                }
            }
            mb[mi].set(wi);
            if(wfree[wi]) {
                m_w[mi] = wi;
                w_m[wi] = mi;
                wfree[wi] = false;
            }
            else {
                int mj = w_m[wi]; // current husband of wi
                if(id(w[wi], mj) > id(w[wi], mi)) { // wi loves mi more
                    m_w[mi] = wi;
                    w_m[wi] = mi;
                    mfree.add(mj); // mj is kicked :(
                }
                else
                    mfree.add(mi); // mi still FA :(
            }
        }

        List<Couple> rs = new ArrayList<>(n);
        for(int i = 0; i < n; ++i)
            rs.add(new Couple(i, m_w[i]));
        return rs;
    }

    int id(int []arr, int x) {
        for(int i = 0; i < arr.length; ++i)
            if(arr[i] == x)
                return i;
        return -1;
    }

    boolean proposedAll(BitSet []mb, int mi, int n) {
        return mb[mi].cardinality() == n;
    }

    class Couple implements Comparable<Couple> {
        int husb, wife;

        public Couple(int husb, int wife) {
            this.husb = husb;
            this.wife = wife;
        }

        @Override
        public int compareTo(Couple o) {
            int t = Integer.compare(husb, o.husb);
            return (t != 0)? t : Integer.compare(wife, o.wife);
        }
    }
}