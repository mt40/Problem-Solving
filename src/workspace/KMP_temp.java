package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class KMP_temp {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        String t = in.nextLine(), p = in.nextLine();
        char []text = t.toCharArray(), pat = p.toCharArray();

        out.println(KMP(text, pat));
    }

    int [] preprocess(char []a) {
        int n = a.length;
        int []fail = new int[n];

        // fail[0] = fail[1] = 0
        for(int i = 2; i < n; ++i) {
            if(a[fail[i - 1]] == a[i])
                fail[i] = fail[i - 1] + 1;
        }

        return fail;
    }

    int KMP(char []text, char []pat) {
        int n = text.length, m = pat.length;

        int []fail = preprocess(pat);
        int len = 0, i = 0, j = 0;
        while(i < n && j < m) {
            if(text[i] == pat[j]) {
                len++;
                i++; j++;
            }
            else {
                if(len > 0) {
                    len -= j - fail[j - 1];
                    j = fail[j - 1];
                }
                else {
                    i++;
                    j = len = 0;
                }
            }
        }

        if(j == m)
            return i - len;
        return -1;
    }
}
