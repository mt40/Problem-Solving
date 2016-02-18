package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;

public class CF_592A {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = 8;
        char [][]a = new char[n][n];
        for(int i = 0; i < n; ++i) {
            char []s = in.next().toCharArray();
            for(int j = 0; j < n; ++j)
                a[i][j] = s[j];
        }

        boolean []mask = new boolean[n];
        int step1 = 8;
        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < n; ++j) {
                if(a[i][j] == 'W' && mask[j] == false) {
                    step1 = i;
                    i = n; j = n;
                }
                else if(a[i][j] == 'B')
                    mask[j] = true;
            }
        }

        mask = new boolean[n];
        int step2 = 8;
        for(int i = n - 1; i >= 0; --i) {
            for(int j = 0; j < n; ++j) {
                if(a[i][j] == 'B' && mask[j] == false) {
                    step2 = n - 1 - i;
                    i = -1; j = n;
                }
                else if(a[i][j] == 'W')
                    mask[j] = true;
            }
        }

        if(step1 <= step2) out.println('A');
        else out.println('B');
    }
}
