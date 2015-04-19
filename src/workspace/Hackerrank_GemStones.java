package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;

public class Hackerrank_GemStones {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int []cnt = new int[26];

        for(int i = 1; i <= n; ++i) {
            char []a = in.next().toCharArray();
            for(int j = 0; j < a.length; ++j)
                if(cnt[a[j] - 'a'] == i - 1)
                    cnt[a[j] - 'a'] = i;
        }

        int ans = 0;
        for(int i = 0; i < 26; ++i)
            if(cnt[i] == n)
                ans++;

        out.println(ans);
    }
}
