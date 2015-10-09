package workspace;

import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.Set;

public class FindPathInMatrix {
    /**
     * Given a matrix A and an array B, check if B is a path in
     * matrix A. Ex:
     * A = 1 2 3   ;  B = 1 2 5
     *     4 5 6
     * We use the naive recursive approach but we add a hash table to
     * cache which cell cannot lead to the answer
     */
    int n, m;
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        n = in.nextInt(); m = in.nextInt();
        int k = in.nextInt();
        int [][]a = new int[n][m];
        for(int i = 0; i < n; ++i)
            for(int j = 0; j < m; ++j)
                a[i][j] = in.nextInt();
        while(k-- > 0) {
            int p = in.nextInt();
            int []b = new int[p];
            for (int i = 0; i < p; ++i)
                b[i] = in.nextInt();

            out.println(find(a, b));
        }
    }

    boolean find(int [][]a, int []b) {
        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < m; ++j) {
                boolean rs = find(a, b, new HashSet<Trip>(), i, j, 0);
                if(rs) return true;
            }
        }
        return false;
    }

    boolean find(int [][]a, int []b, Set<Trip> cache, int i, int j, int k) {
        if(k == b.length) return true;
        if(i < 0 || i == n || j < 0 || j == m) return false;
        Trip cur = new Trip(i, j, k);
        if(cache.contains(cur))
            return false;
        // if this path can lead to result
        if(a[i][j] == b[k] && (
                        find(a, b, cache, i - 1, j, k + 1) ||
                        find(a, b, cache, i, j + 1, k + 1) ||
                        find(a, b, cache, i + 1, j, k + 1) ||
                        find(a, b, cache, i, j - 1, k + 1)
                ))
            return true;
        cache.add(cur); // mark as a bad path and never go this path again
        return false;
    }

    class Trip {
        int A, B, C;

        public Trip(int a, int b, int c) {
            A = a;
            B = b;
            C = c;
        }
    }
}
