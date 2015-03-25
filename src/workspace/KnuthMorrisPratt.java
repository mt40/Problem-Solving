package workspace;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class KnuthMorrisPratt {
    char []text, pat; // text and pattern
    int []a;
    int n, m;

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        String t = in.nextLine();
        String p = in.nextLine();
        text = t.toCharArray();
        pat = p.toCharArray();
        n = t.length();
        m = p.length();
        a = new int[m];

        kmpPreprocess();
        //out.println(Arrays.toString(a));
        kmpSearch();
    }

    void kmpPreprocess() {
        int i = 0, j = -1;
        a[0] = -1;
        while(i < m) {
            while(j >= 0 && pat[i] != pat[j])
                j = a[j]; // reset j
            i++; j++;
            if(i < m)
                a[i] = j;
        }
    }

    // same as preprocessing
    void kmpSearch() {
        int i = 0, j = 0;
        while(i < n) {
            while(j >= 0 && text[i] != pat[j]) {
                j = a[j];
                //System.out.print(j + "->");
            }
            i++; j++; //System.out.format("j=%d, i=%d\n", j, i);
            if(j == m) {
                System.out.format("Match at %d\n", i - j);
                j--; // j = m is out of bound so subtract 1
                j = a[j] + 1; // reset j for next search
            }
        }
    }
}
