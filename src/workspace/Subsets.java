package workspace;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class Subsets {
    int n, cnt;
    int []a, m;
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        cnt = 0;
        n = in.nextInt();
        a = new int[n];
        m = new int[n];

        for(int i = 0; i < n; ++i)
            a[i] = in.nextInt();

        for(int i = 0; i <= n; ++i)
            subset(i, 0);

        out.format("Total %d", cnt);
    }

    void subset(int len, int cur) {
        if(len == 0) {
            print();
            return;
        }
        for(int i = cur; i < n; ++i) {
            if(m[i] == 0) {
                m[i] = 1;
                subset(len - 1, i + 1);
                m[i] = 0;
            }
        }
    }

    void print() {
        cnt++;
        for(int i = 0; i < n; ++i)
            if(m[i] == 1)
                System.out.print(a[i] + " ");
        System.out.println();
    }
}
