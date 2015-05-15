package workspace;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class CF_389B {
    int INF = 1 << 31 - 1;

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        char[][] a = new char[n][n];
        for(int i = 0; i < n; ++i) {
            char []cc = in.next().toCharArray();
            for(int j = 0; j < n; ++j)
                a[i][j] = cc[j];
        }

        for (int i = 0; i < n - 2; ++i) {
            for (int j = 1; j < n - 1; ++j) {
                if (a[i][j] == '#')
                    mark(a, i, j);
            }
        }

        String ans = "YES";
        for(int i = 0; i < n; ++i)
            for(int j = 0; j < n; ++j)
                if(a[i][j] == '#')
                    ans = "NO";
        out.println(ans);
    }

    void mark(char[][] a, int i, int j) {
        if (a[i][j] == '#' && a[i + 1][j - 1] == '#'
                && a[i + 1][j] == '#' && a[i + 1][j + 1] == '#'
                && a[i + 2][j] == '#')
            a[i][j] = a[i + 1][j - 1] = a[i + 1][j] = a[i + 1][j + 1] = a[i + 2][j] = '.';
    }
}
