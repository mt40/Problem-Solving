package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class KMP {
    /**
     * KMP implementation l?n th? 3
     */
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        String s1 = in.nextLine(), s2 = in.nextLine();
        char []text = s1.toCharArray(), pattern = s2.toCharArray();
        int n = text.length, m = pattern.length;

        int ans = kmpSearch(text, pattern);
        if(ans >= 0)
            out.println("Match at " + ans);
        else
            out.println("No match");
    }

    int[] kmpPreprocess(char []pattern) {
        int n = pattern.length;
        int []fail = new int[n];
        // fail[0] = fail[1] = 0
        for(int i = 2; i < n; ++i) {
            if(pattern[fail[i - 1]] == pattern[i]) {
                fail[i] = fail[i - 1] + 1;
            }
        }

        return fail;
    }

    int kmpSearch(char []text, char[]pattern) {
        int n = text.length, m = pattern.length, match_len = 0;
        int []fail = kmpPreprocess(pattern);
        int i = 0, j = 0;
        while(i < n && j < m) {
            if(text[i] == pattern[j]) {
                match_len++;
                i++; j++;
            }
            else if(match_len > 0){
                int skip = match_len - fail[j - 1]; // skip equal elements
                match_len = fail[j - 1];
                j -= skip;
            }
            else {
                i++;
                match_len = j = 0;
            }
        }
        if(j == m) {
            return i - match_len;
        }
        return -1;
    }
}
