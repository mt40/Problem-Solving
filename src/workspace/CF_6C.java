package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class CF_6C {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int []a = new int[n];
        for(int i = 0; i < n; ++i)
            a[i] = in.nextInt();

        int i = 0, j = n - 1;
        int alice = a[0], bob = a[n - 1];
        while(i < j - 1 && i < n && j >= 0) {
            if(alice <= bob) {
                i++;
                alice += a[i];
            }
            else {
                j--;
                bob += a[j];
            }
        }

        if(n == 1)
            out.println("1 0");
        else
            out.println((i + 1) + " " + (n - j));
    }
}
