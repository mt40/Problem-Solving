package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;

import helperClasses.FastScanner;
import helperClasses.Util;

public class NextSmallestPalindrome {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        int []a = in.arr(n);

        boolean isAll9 = isAll9(a);

        if(isAll9) {
            a = new int[n + 1];
            a[0] = a[n] = 1;
        }
        else {
            int left = n / 2 - 1, right = n - 1 - left;
            if (a[left] <= a[right]) {
                int mid = (n - 1) / 2;
                while (mid >= 0 && a[mid] == 9)
                    a[mid--] = 0;
                a[mid]++;
            }
            // copy the left part to the right
            for (int i = 0; i <= left; ++i)
                a[n - 1 - i] = a[i];
        }
        for(int ai : a)
            out.print(ai + " ");
        out.println();
    }

    boolean isAll9(int []a) {
        for(int ai : a)
            if(ai != 9)
                return false;
        return true;
    }
}