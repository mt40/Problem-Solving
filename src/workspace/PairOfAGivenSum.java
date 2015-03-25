package workspace;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class PairOfAGivenSum {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int sum = in.nextInt();
        int n = in.nextInt();
        int []a = new int[n];

        for(int i = 0; i < n; ++i)
            a[i] = in.nextInt();

        Arrays.sort(a);
        int low = 0, hi = n - 1;
        while(low <= hi) {
            int cal = a[low] + a[hi];
            if(cal == sum) {
                out.format("%d = %d + %d", sum, a[low], a[hi]);
                return;
            }
            if(cal < sum)
                low++;
            else
                hi--;
        }

        out.println("No valid pair");
    }
}
