package workspace;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class SubsetSumModN {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt(), m = in.nextInt();
        int []a = new int[n];
        for(int i = 0; i < n; ++i)
            a[i] = in.nextInt();

        while(m-- > 0) {
            int res = in.nextInt(); // residue
            out.printf("Subset sum = %d mod N is %s\n", res, subsetSumMod(a, res));
        }
    }

    String subsetSumMod(int []a, int res) {
        int n = a.length;
        int []table = new int[n];
        Arrays.fill(table, -1);
        int []prefix_sum = new int[n];
        for(int i = 0; i < n; ++i) {
            prefix_sum[i] = a[i];
            prefix_sum[i] += (i > 0) ? prefix_sum[i - 1] % n : 0;
            prefix_sum[i] %= n;
            if(prefix_sum[i] == res) {
                return String.format("[%d : %d]", 0, i);
            }
            else if(prefix_sum[i] >= res && table[prefix_sum[i] - res] >= 0){
                return String.format("[%d : %d]", table[prefix_sum[i] - res] + 1, i);
            }
            else if(prefix_sum[i] - res + n >= 0 && prefix_sum[i] < res
                    && table[prefix_sum[i] - res + n] >= 0) {
                return String.format("[%d : %d]", table[prefix_sum[i] - res + n] + 1, i);
            }
            table[prefix_sum[i]] = i;
        }

        return "None";
    }
}
