package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.HashSet;
import java.util.TreeSet;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_HERDING {
    int inf = Integer.MAX_VALUE;

    int n, m;
    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        n = in.i(); m = in.i();
        char [][]a = new char[n][m];
        for(int i = 0; i < n; ++i) {
            char []t = in.c();
            for(int j = 0; j < m; ++j)
                a[i][j] = t[j];
        }

        djset = new Subset[n * m];
        for(int i = 0; i < djset.length; ++i) djset[i] = new Subset(i);
        boolean [][]vst = new boolean[n][m];
        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < m; ++j) {
                if(i < n - 1 && a[i + 1][j] == 'N')
                    union(i, j, i+1, j);
                if(j < m - 1 && a[i][j + 1] == 'W')
                    union(i, j, i, j + 1);
                if(i > 0 && a[i - 1][j] == 'S')
                    union(i, j, i - 1, j);
                if(j > 0 && a[i][j - 1] == 'E')
                    union(i, j, i, j - 1);
            }
        }

        int ans = 0;
        for(int i = 0; i < djset.length; ++i)
            if(djset[i].parent == i)
                ans++;
        out.println(ans);
    }

    Subset []djset;

    int index(int i, int j) {
        return i * m + j;
    }

    void union(int i1, int j1, int i2, int j2) {
        int x = index(i1, j1), y = index(i2, j2);
        if(djset[x].parent == djset[y].parent)
            return;

        int rootx = find(x), rooty = find(y);
        if(djset[rootx].rank < djset[rooty].rank)
            djset[rootx].parent = rooty;
        else if(djset[rootx].rank > djset[rooty].rank)
            djset[rooty].parent = rootx;
        else { // equal
            djset[rooty].parent = rootx;
            djset[rootx].rank++;
        }
    }

    int find(int i) {
        if(djset[i].parent != i)
            djset[i].parent = find(djset[i].parent);
        return djset[i].parent;
    }

    class Subset {
        Pair p;
        int rank;
        int parent;

        public Subset(int parent) {
            this.parent = parent;
        }
    }

    class Pair {
        int i, j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }

        void set(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (i != pair.i) return false;
            return j == pair.j;

        }
    }
}