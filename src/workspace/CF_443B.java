package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class CF_443B {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        char []a = in.next().toCharArray();
        int n = a.length;
        int k = in.nextInt();

        int ans = 0;
        for(int i = n - 1; i >= 0; --i) {
            int len = k + (n - i);
            if((len & 1) == 0) {
                if(check(a, n, len, i))
                    ans = len;
            }
        }

        // trap: we have to find the existing longest tandem repeat
        int max = 0;
        for(int len = 2; len <= n; len += 2) {
            for(int i = 0; i + len - 1 < n; ++i) {
                if(check(a, n, len, i))
                    max = len;
            }
        }

        out.println(Math.max(max, ans));
    }

    boolean check(char []a, int n, int len, int i) {
        for(int j = i; j < i + len/2; ++j) {
            char l = (j >= n) ? '?' : a[j];
            char r = (j + len/2 >= n) ? '?' : a[j + len/2];
            if(l != r && l != '?' && r != '?')
                return false;
        }
        return true;
    }
}
