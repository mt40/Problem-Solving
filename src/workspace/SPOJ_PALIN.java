package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class SPOJ_PALIN {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        String s = in.next();
        char []ss = s.toCharArray();
        int n = ss.length;

        int []a = new int[n];
        for(int i = 0; i < n; ++i)
            a[i] = ss[i] - '0';

        boolean isNine = true;
        for(int i = 0; i < n; ++i)
            if(a[i] != 9)
                isNine = false;

        if(isNine) {
            String ans = "1";
            for(int i = 0; i < n - 1; ++i)
                ans += "0";
            ans += "1";
            out.println(ans);
        }
        else {
            boolean flag = true; // do we have to increase ?
            // check if the right side is larger
            for(int i = n / 2 - 1; i >= 0; --i) {
                if (a[i] > a[n - i - 1]) {
                    flag = false;
                    break;
                }
                else if(a[i] < a[n - i - 1]) {
                    flag = true;
                    break;
                }
            }
            // check if this number is palindrome
            if(isPalind(a, n)) flag = true;

            // increase the middle value
            if(flag) {
                int pos = n / 2;
                if(n % 2 == 0) pos--;
                // have to do this in case we increase the number 9
                while(a[pos] == 9 && pos > 0) {
                    a[pos] = 0;
                    pos--;
                }
                a[pos]++;
            }

            // reflect the left part to the right part
            for(int i = 0; i < n / 2; ++i)
                a[n - i - 1] = a[i];

            // print
            for(int i = 0; i < n; ++i)
                out.print(a[i]);
            out.println();
        }
    }

    boolean isPalind(int []x, int n) {
        boolean rs = true;
        for(int i = 0; i < n / 2; ++i)
            if(x[i] != x[n - i - 1])
                return false;
        return true;
    }
}
