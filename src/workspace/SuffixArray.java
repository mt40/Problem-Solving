package workspace;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class SuffixArray {
    int n, logN;
    String s;
    char []a;
    int [][]tree;
    Box []b;

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        n = in.nextInt();
        s = in.next();
        a = s.toCharArray();

        // use array b to keep values for comparison
        b = new Box[n];
        for(int i = 0; i < n; ++i)
            b[i] = new Box();

        logN = log2(n);
        tree = new int[logN + 1][n];

        // Idea: tree[i][j] is suffix of length 2^i starts at j
        // i here is considered as length
        // --------------------------------------------------------
        // Pre-process
        for(int i = 0; i < n; ++i)
            tree[0][i] = (int)a[i] - (int)'a';

        for(int i = 1; i <= logN; ++i) {
            for(int j = 0; j < n; ++j) {
                b[j].item1 = tree[i - 1][j]; // left part
                if(j + (1 << (i - 1)) >= n) // out of bound
                    b[j].item2 = -1;
                else
                    b[j].item2 = tree[i - 1][j + (1 << (i - 1))];
                b[j].pos = j;
            }
            Arrays.sort(b);

            for(int j = 0; j < n; ++j) {
                // if b[i] equal b[i - 1];
                if(j > 0 && b[j].item1 == b[j - 1].item1 && b[j].item2 == b[j - 1].item2)
                    tree[i][b[j].pos] = tree[i][b[j - 1].pos];
                else
                    tree[i][b[j].pos] = j;
            }
        }

        out.format("Yay! Suffix array: %s\n", Arrays.toString(tree[logN]));
        int k = 3;
        out.format("%d-th suffix is: %s\n", k, suffix_Kth(tree[logN], k));
        int x = 0, y = 2;
        out.format("LCP of %d-th & %d-th suffixes: %d\n",
                x, y, LCP(x, y));

        for(int i = 0; i < tree.length; ++i)
            out.println(Arrays.toString(tree[i]));
    }

    // Find the k-th suffix
    String suffix_Kth(int []suffix_arr, int k) {
        for(int i = 0; i < suffix_arr.length; ++i)
            if(suffix_arr[i] == k)
                return s.substring(i);
        return null;
    }

    // Longest Common Prefix of 2 suffixes start from x, y
    int LCP(int x, int y) {
        if(x == y) return n - x;

        int rs = 0;
        for(int k = logN; k >= 0 && x < n && y < n; k--) {
            if(tree[k][x] == tree[k][y]) {
                x += (1 << k);
                y += (1 << k);
                rs += (1 << k);
            }
        }
        return rs;
    }

    int log2(int x) {
        int rs = 1;
        while(1 << (rs + 1) <= x) rs++;
        return rs;
    }

    /**
     * This class is used to keep 2 values and starting position
     * (just like Segment Tree)
     * value 1: (left) pos -> pos + 2^i - 1
     * value 2: (right) pos + 2^i -> pos + 2^(i + 1)
     */
    class Box implements Comparable<Box> {
        int item1, item2, pos;

        @Override
        public int compareTo(Box o) {
            if(this.item1 == o.item1)
                if(item2 == o.item2)
                    return 0;
                else return item2 < o.item2 ? 1 : -1;
            else
                return this.item1 < o.item1 ? 1 : -1;
        }

        @Override
        public String toString() {
            return "(" + item1 + "," + item2 + ")";
        }
    }
}
