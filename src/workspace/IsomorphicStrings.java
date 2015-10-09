package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class IsomorphicStrings {
    /**
     * Check if 2 strings are isomorphic
     */
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        String s1 = in.next(), s2 = in.next();
        char[] a = s1.toCharArray(), b = s2.toCharArray();
        int n = a.length, m = b.length;

        boolean ans = true;
        char []map = new char[26];
        for (int i = 0; i < n; ++i) {
            if (map[a[i] - 'a'] == 0)
                map[a[i] - 'a'] = b[i];
            else if (map[a[i] - 'a'] != b[i]) {
                ans = false;
                break;
            }
        }

        out.println(ans);
    }
}
