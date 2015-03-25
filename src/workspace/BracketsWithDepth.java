package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class BracketsWithDepth {
    int n, k;

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        n = in.nextInt(); k = in.nextInt();

        cal(new int[n], 0, 0, 0);
    }

    public void cal(int []a, int len, int balance, int depth) {
        if(balance < 0 || depth > k) return; // close brackets more than open or too many open
        if(len == n) {
            if(balance == 0 && depth == k) {
                System.out.print(depth + " ");
                print(a);
            }
            return;
        }
        for(int i = 0; i <= 1; ++i) {
            a[len] = i;
            if(i == 0)
                cal(a, len + 1, balance - 1, depth);
            else
                cal(a, len + 1, balance + 1, Math.max(balance + 1, depth));
        }
    }

    public void print(int []a) {
        for(int i = 0; i < a.length; ++i) {
            if (a[i] == 1)
                System.out.print('(');
            else
                System.out.print(')');
        }
        System.out.println();
    }
}
