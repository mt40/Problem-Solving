package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class CF_600C {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        char[] a = in.next().toCharArray();
        int n = a.length;

        int[] f = new int[26];
        for (int i = 0; i < n; ++i) {
            f[a[i] - 'a']++;
        }

        int l = 0, r = 25;
        while (l < r) {
            while (l < 26 && f[l] % 2 == 0) l++;
            while (r >= 0 && f[r] % 2 == 0) r--;
            if (l < r) {
                f[l]++;
                f[r]--;
                l++;
                r--;
            }
        }

        StringBuilder pre = new StringBuilder(), post = new StringBuilder();
        char mem = '$';
        for (int i = 0; i < 26; ++i) {
            if (f[i] <= 0)
                continue;
            while (f[i] > 0) {
                if(f[i] == 1) {
                    mem = (char)('a' + i);
                    f[i] = 0;
                    continue;
                }
                pre.append((char) ('a' + i));
                post.insert(0,(char) ('a' + i));
                f[i] -= 2;
            }
        }
        String ans = pre.append(mem == '$'? "" : mem).append(post).toString();
        out.println(ans);
    }
}
