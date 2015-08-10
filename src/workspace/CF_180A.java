package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class CF_180A {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        char[] a = in.next().toCharArray();
        char[] b = in.next().toCharArray();
        int n = count1(a), m = count1(b);

        boolean ans = false;
        n += (n % 2 != 0) ? 1 : 0;
        if(m <= n)
            ans = true;

        out.println(convert(ans));
    }

    String convert(boolean b) {
        return (b == true) ? "YES" : "NO";
    }

    int count1(char[] a) {
        int one = 0;
        for(char c : a)
            one += (c == '1') ? 1 : 0;
        return one;
    }
}
