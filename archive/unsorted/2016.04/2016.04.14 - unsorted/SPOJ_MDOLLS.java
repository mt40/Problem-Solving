package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_MDOLLS {
    int inf = Integer.MAX_VALUE;
    Doll []dolls;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        dolls = new Doll[n];
        for(int i = 0; i < n; ++i) {
            dolls[i] = new Doll(in.i(), in.i());
        }

        Arrays.sort(dolls, cprt);

        boolean []isContained = new boolean[n]; // container[i] = container of doll i
        List<Doll> pool = new ArrayList<>();

        for(int i = n - 1; i >= 0; --i) {
            Doll doll = dolls[i];
            int idx = find(pool, doll);
            if(idx >= 0) {
                isContained[i] = true;
                Doll container = pool.get(idx);
                /**
                 * First, I removed the container doll & add the current doll
                 * to the head of the list. But that makes the complexity O(n^2).
                 * The trick is to replace the container doll's data directly.
                 * The order of the list @poll is maintained because we are
                 * looping in descending order and also binary search for
                 * the minimum possible container
                 */
                container.width = doll.width;
                container.height = doll.height;
            }
            else
                pool.add(0, doll);
        }

        int ans = 0;
        for(boolean b : isContained)
            if(!b) ans ++;

        out.println(ans);
    }

    int find(List<Doll> list, Doll key) {
        int low = 0, hi = list.size() - 1, min = -1;
        while(low <= hi) {
            int mid = (low + hi) >>> 1;
            Doll d = list.get(mid);
            if(d.canContain(key)) {
                min = mid;
                hi = mid - 1;
            }
            else low = mid + 1;
        }
        return min;
    }

    Comparator<Doll> cprt = (d1, d2) -> {
        int t = Integer.compare(d1.width, d2.width);
        return (t != 0) ? t : Integer.compare(d1.height, d2.height);
    };

    class Doll {
        int width, height;

        public Doll(int width, int height) {
            this.width = width;
            this.height = height;
        }

        boolean canContain(Doll other) {
            return width > other.width && height > other.height;
        }
    }
}