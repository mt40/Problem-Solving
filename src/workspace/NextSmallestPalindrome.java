package workspace;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class NextSmallestPalindrome {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        String s = in.next();
        char []c = s.toCharArray();
        int n = c.length;
        int []a = new int[n + 1];
        boolean allNine = true;
        for(int i = 0; i < n; ++i) {
            a[i] = c[i] - '0';
            if(a[i] != 9) allNine = false;
        }

        // case all numbers are 9
        if(allNine) {
            Arrays.fill(a, 0);
            a[0] = a[n] = 1;
        }
        else { // normal case
            int left_mid = (n % 2 == 0) ? (n - 1) / 2 : n / 2 - 1;
            if (a[left_mid] < a[n - 1 - left_mid]) {
                if (n % 2 == 0)
                    a[left_mid]++;
                else
                    a[left_mid + 1]++; // increase the middle number
            }
            // mirror the left part
            for (int i = left_mid; i >= 0; --i) {
                a[n - 1 - i] = a[i];
            }
        }

        for(int i = 0; i < n; ++i)
            out.print(a[i]);
        if(allNine) out.print(a[n]);
        out.println();
    }
}
