package workspace;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class KnuthMorrisPrath2 {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        String t = in.next(), p = in.next();
        char []pat = p.toCharArray(), text = t.toCharArray();

        //out.println(Arrays.toString(kmpPreprocess(a)));
        out.println(kmpSearch(pat, text));
    }

    int[] kmpPreprocess(char []pat) {
        int n = pat.length;
        int []fail = new int[n];
        fail[0] = 0;
        if(n > 1) fail[1] = 0;
        for(int i = 2; i < n; ++i) {
            int j = fail[i - 1];
            if(pat[j] == pat[i])
                fail[i] = j + 1;
        }
        return fail;
    }

    int kmpSearch(char []pat, char[]text) {
        int []fail = kmpPreprocess(pat);

        int n = pat.length, m = text.length;
        int i = 0, j = 0;
        int match_len = 0;
        while(j < n && i < m) {
            if(pat[j] == text[i]) {
                i++; j++; match_len++;
                if(match_len == n)
                    return i - n;
            }
            else if(match_len >= 1 && fail[j - 1] > 0) {
                int skip = match_len - fail[j - 1];
                j -= skip;
                match_len -= skip;
                System.out.printf("Mismatch at %d -> skip %d char\n", i, skip);
            }
            else {
                i++; j = 0;
                match_len = 0;
            }
        }
        return -1;
    }
}
