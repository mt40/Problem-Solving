package workspace;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class CF_339D {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        int pow2 = 1 << n;
        int []a = new int[pow2];
        for(int i = 0; i < pow2; ++i)
            a[i] = in.nextInt();

        /**
         * ý t??ng: tree[i][j] = k?t qu? c?a chu?i b?t ??u t?i j ?? dài là 2^i
         */
        int [][]tree = new int[n + 1][pow2];
        for(int j = 0; j < pow2; ++j) {
            tree[0][j] = a[j];
        }
        for(int i = 1; i <= n; ++i) {
            int prev_len = 1 << (i - 1);
            int len = 1 << i;
            for(int j = 0; j < pow2; j += len) {
                if((i & 1) != 0) {
                    tree[i][j] = tree[i - 1][j] | tree[i - 1][j + prev_len];
                }
                else {
                    tree[i][j] = tree[i - 1][j] ^ tree[i - 1][j + prev_len];
                }
            }
        }

//        update(tree, 0, 4);
//        update(tree, 2, 4);
//
//        for(int i = 0; i <= n; ++i)
//            System.out.println(Arrays.toString(tree[i]));
        for(int i = 0; i < m; ++i) {
            int p = in.nextInt();
            int b = in.nextInt();
            update(tree, p - 1, b);
            out.println(tree[n][0]);
        }

    }

    void update(int [][]tree, int pos, int val) {
        tree[0][pos] = val;
        for(int i = 1; i < tree.length; ++i) {
            int start = pos / (1 << i) * (1 << i);
            int prev_len = 1 << (i - 1);
            if((i & 1) != 0)
                tree[i][start] = tree[i - 1][start] | tree[i - 1][start + prev_len];
            else
                tree[i][start] = tree[i - 1][start] ^ tree[i - 1][start + prev_len];
        }
    }
}
