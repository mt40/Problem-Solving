package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class LowerUpper {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        String s = in.next();

        toLower(s);
        toUpper(s);
        flipCase(s);
    }

    public void toLower(String s) {
        char []a = s.toCharArray();
        int n = a.length;

        // to lower
        for(int i = 0; i < n; ++i)
            a[i] = 'a' > a[i] ? (char)(a[i] - 'A' + 'a') : a[i];
        System.out.println(String.valueOf(a));
    }

    public void toUpper(String s) {
        char []a = s.toCharArray();
        int n = a.length;

        // to upper
        for(int i = 0; i < n; ++i)
            a[i] = 'a' <= a[i] ? (char)(a[i] - 'a' + 'A') : a[i];
        System.out.println(String.valueOf(a));
    }

    public void flipCase(String s) {
        char []a = s.toCharArray();
        int n = a.length;

        // flip case
        for(int i = 0; i < n; ++i)
            a[i] = 'a' > a[i] ? (char)(a[i] - 'A' + 'a') : (char)(a[i] - 'a' + 'A');
        System.out.println(String.valueOf(a));
    }
}
