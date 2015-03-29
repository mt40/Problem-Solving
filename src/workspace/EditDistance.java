package workspace;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class EditDistance {
    char []text, pat;
    int n, m;

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        String t = ' ' + in.nextLine(); // to make it 1-base indexing
        String p = ' ' + in.nextLine();
        text = t.toCharArray();
        pat = p.toCharArray();
        n = text.length;
        m = pat.length;

        // dp[i][j] optimal score of A: 0...i & B: 0...j
        int [][]dp = new int[n][m];

        // preprocess
        for(int i = 0; i < n; ++i)
            dp[i][0] = i * score(text[i], ' '); // delete all a[i]
        for(int j = 0; j < m; ++j)
            dp[0][j] = j * score(' ', pat[j]); // insert spaces to a[i]

        for(int i = 1; i < n; ++i) {
            for(int j = 1; j < m; ++j) {
                int match = dp[i - 1][j - 1] + score(text[i], pat[j]);
                int del = dp[i - 1][j] + score(text[i], ' ');
                int ins = dp[i][j - 1] + score(' ', pat[j]);
                dp[i][j] = _max(match, del, ins);
            }
        }

        out.println(dp[n - 1][m - 1]);
    }

    int score(char a, char b) {
        if(a != b) return -1;
        return 2;
    }

    int _max(int ... nums) {
        int rs = nums[0];
        for(int i = 1; i < nums.length; ++i)
            if(nums[i] > rs)
                rs = nums[i];
        return rs;
    }
}
