package workspace;

import java.util.*;
import java.io.PrintWriter;

public class CapsAssignment {
    /**
     * There are 100 caps to assign to 10 men. Each man has his list
     * of favorite caps and he only wants to wear them. No 2 men should
     * wear the same type of cap.
     * Approach: dp + bitmask
     * http://www.geeksforgeeks.org/bitmasking-and-dynamic-programming-set-1-count-ways-to-assign-unique-cap-to-every-person/
     */
    boolean [][]fav_caps;
    long [][]dp;
    int n, m;
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        n = in.nextInt(); // caps
        m = in.nextInt(); // men
        fav_caps = new boolean[n][m];
        for(int i = 0; i < m; ++i) {
            int cnt = in.nextInt();
            while(cnt-- > 0)
                fav_caps[in.nextInt()][i] = true;
        }

        /**
         * dp(i, j) = ket qua khi xet toi cap j, i la bitmask cho
         * biet ai da dc assign cap roi
         */
        allmask = (1 << m) - 1; // set all bit to 1
        dp = new long[1 << m][n];
        for(int i = 0; i < dp.length; ++i)
            Arrays.fill(dp[i], -1);
        out.println(cal(0, 0, new ArrayList<Pair>()));
    }

    int allmask; // all bits are set to 1
    long cal(int mask, int cap_id, List<Pair> trace) {
        // All men are wearing caps-> done
        // also, this is 1 way to arrage the caps so return 1
        if(mask == allmask) {
            List<Pair> tmp = new ArrayList<Pair>(trace);
            Collections.sort(tmp);
            for(Pair x : tmp) System.out.print(x + " ");
            System.out.println();
            return 1;
        }
        // If not everyone is wearing cap and there is no more
        // cap left
        if(cap_id >= n) return 0;
        // If this is processed, return the calculated value
        if(dp[mask][cap_id] != -1) return dp[mask][cap_id];

        // Not include this cap
        long ways = cal(mask, cap_id + 1, trace);

        // Include this cap
        // Assign this cap to the possible man
        int size = fav_caps[cap_id].length; // number of men favor this cap
        for(int i = 0; i < size; ++i) {
            if(fav_caps[cap_id][i]) {
                boolean already_wear = (mask & (1 << i)) > 0;
                if(already_wear) continue; // this man is wearing a cap already
                // Else, assign cap for this man
                Pair pair = new Pair(i, cap_id);
                trace.add(pair);
                ways += cal(mask | (1 << i), cap_id + 1, trace);
                trace.remove(pair);
            }
        }

        return dp[mask][cap_id] = ways;
    }

    class Pair implements Comparable<Pair>{
        int A, B;

        public Pair(int a, int b) {
            A = a;
            B = b;
        }

        @Override
        public String toString() {
            return String.format("man %d:cap %d", A, B);
        }

        @Override
        public int compareTo(Pair o) {
            return Integer.compare(A, o.A);
        }
    }
}
