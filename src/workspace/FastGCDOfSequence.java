package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class FastGCDOfSequence {
    int n;
    int []a;
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        n = in.nextInt();
        a = new int[n + 1];

        for(int i = 1; i < n; ++i)
            a[i] = in.nextInt();

        int log = log2(n);
        int [][]tree = new int[n + 1][log + 1];

        for(int i = 1; i <= n; ++i)
            tree[i][0] = a[i];

        for(int len = 1; len <= log; ++len) {
            for(int i = 1; i + 1 << len - 1 <= n; ++i) {
                int mid = i + 1 << (len - 1);
                int left = tree[i][len - 1];
                int right = tree[mid][len - 1];
                tree[i][len] = gcd(left, right);
            }
        }

        out.println(rangeGCD(tree, 1, 3));
    }

    int rangeGCD(int [][]tree, int l, int r) {
        int log = log2(r - l + 1);
        return gcd(tree[l][log], tree[r - (1 << log) + 1][log]);
    }

    int log2(int a) {
        int rs = 0;
        while((1 << (rs + 1)) <= a) rs++;
        return rs;
    }

    int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }
}
