package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;

public class CF_465C {
    final int Z = 'z' + 1;

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int k = in.nextInt() + 'a';
        char []a = in.next().toCharArray();

        /**
         * Idea: find the rightmost possible letter that we can change
         * to get the no-palindrome string, set all letters to the right
         * of that position to 'a'
         * Finally, go from i + 1 -> n - 1 and improve those 'a's
         */
        for(int i = n - 1; i >= 0; --i) {
            int j = (int)a[i] + 1;
            for(; j < k && j <= Z; ++j) {
                char c = (char)j;
                if(check(a, i, c)) {
                    a[i] = c;
                    // fix the letters to the right
                    for(int t = i + 1; t < n; ++t) {
                        while(!check2(a, t, a[t]))
                            a[t] = (char)(a[t] + 1);
                    }
                    out.println(String.valueOf(a));
                    return;
                }
            }
            a[i] = 'a';
        }
        out.println("NO");
    }

    boolean check(char []a, int pos, char c) {
        for(int i = pos - 1; i >= pos - 2 && i >= 0; --i)
            if(a[i] == c)
                return false;
        for(int i = pos + 1; i <= pos + 2 && i < a.length; ++i)
            if(a[i] == c)
                return false;
        return true;
    }

    boolean check2(char []a, int pos, char c) {
        for(int i = pos - 1; i >= pos - 2 && i >= 0; --i)
            if(a[i] == c)
                return false;
        return true;
    }
}
