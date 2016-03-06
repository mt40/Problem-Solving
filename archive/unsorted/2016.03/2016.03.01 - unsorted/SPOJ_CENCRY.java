package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_CENCRY {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        char []vowel = "aeiou".toCharArray();
        char []conso = "bcdfghjklmnpqrstvwxyz".toCharArray();
        int h = vowel.length, k = conso.length;

        char []a = in.c();
        int n = a.length;

        int []cnt = new int[26];
        char []encoded = new char[n];
        int idx = 0;
        for(char c : a) {
            int f = cnt[c-'a'];
            cnt[c-'a']++;

            if(find(vowel, c) >= 0) {
                int posV = find(vowel, c);
                int posC = (posV + f * h) % k;
                char after = conso[posC];
                encoded[idx++] = after;
            }
            else {
                int posV = find(conso, c);
                int posC = (posV + f * k) % h;
                char after = vowel[posC];
                encoded[idx++] = after;
            }
        }

        out.println(String.valueOf(encoded));
    }

    int find(char []a, char c) {
        for(int i = 0; i < a.length; ++i)
            if(a[i] == c)
                return i;
        return -1;
    }
}