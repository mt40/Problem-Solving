package workspace;

import java.util.*;
import java.io.PrintWriter;

public class CF_593A {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        List<char[]> list = new ArrayList<>();
        for(int i = 0; i < n; ++i) {
            list.add(in.next().toCharArray());
        }

        int []cnt1 = new int[26];
        int [][]cnt2 = new int[26][26];
        for(int i = 0; i < n; ++i) {
            Set<Character> set = new TreeSet<>();
            char []a = list.get(i);
            for(char c : a)
                set.add(c);
            Character []set_c = new Character[set.size()];
            set.toArray(set_c);
            if(set_c.length == 1)
                cnt1[set_c[0] - 'a'] += a.length;
            if(set_c.length == 2)
                cnt2[set_c[0] - 'a'][set_c[1] - 'a'] += a.length;
        }

        int ans = 0;
        for(int i = 0; i < 26; ++i) {
            for(int j = 0; j < 26; ++j) {
                if(i == j)
                    ans = Math.max(cnt1[j] + cnt2[i][j], ans);
                else
                    ans = Math.max(cnt1[j] + cnt1[i] + cnt2[i][j] + cnt2[j][i], ans);
            }
        }

        out.println(ans);
    }
}
