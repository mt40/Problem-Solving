package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class Permutation {
    int n, cnt;
    char []a;
    int []m;

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        n = in.nextInt();
        String s = in.next();
        a = s.toCharArray();
        m = new int[n];

        permutation("", n);
        out.format("Total %d", cnt);
    }

    void permutation(String rs, int len) {
        if(len == 0) {
            cnt++;
            System.out.println(rs);
            return;
        }
        for(int i = 0; i < n; ++i) {
            if(m[i] == 0) {
                m[i] = 1;
                permutation(rs + a[i], len - 1);
                m[i] = 0;
            }
        }
    }
}
