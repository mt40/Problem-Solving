package workspace;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class SegmentTree {
    int n, logN;
    int []a;
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        n = in.nextInt();
        a = new int[n];

        for(int i = 0; i < n; ++i)
            a[i] = in.nextInt();

        int ans1 = rmqDP(4, 13), ans2 = rmqST(4, 13);
        out.format("(DP)\nrmq: %d at: %d\n", a[ans1], ans1);
        out.format("(Sparse table)\nrmq: %d at: %d", a[ans2], ans2);
    }

    /**
     * DP approach
     * dp[i][j]: position of the minimum number in a[i...j]
     * complexity: < O(n^2), O(1)>
     */
    public int rmqDP(int low, int hi) {
        int [][]dp = new int[n][n];
        for(int i = 0; i < n; ++i)
            dp[i][i] = i;

        for(int i = 0; i < n; ++i) {
            for(int j = i + 1; j < n; ++j) {
                if(a[dp[i][j - 1]] < a[j])
                    dp[i][j] = dp[i][j - 1];
                else
                    dp[i][j] = j;
            }
        }
        //print(dp);
        return dp[low][hi];
    }

    /**
     * Sparse table approach
     * complexity < O(nlogn), O(1) >
     */
    public int rmqST(int low, int hi) {
        logN = log2(n);
        int [][]st = new int[n][logN + 1];

        // Initialize for length 1
        for(int i = 0; i < n; ++i)
            st[i][0] = i;

        // Loop by length
        for(int j = 1; 1 << j <= n; ++j) {
            for(int i = 0; i + (1 << j) - 1 < n; ++i) {
                int left = st[i][j - 1];
                int right = st[i + (1 << (j - 1))][j - 1];
                if(a[left] <= a[right])
                    st[i][j] = left;
                else
                    st[i][j] = right;
            }
        }

        // Calculate rmq(low, high)
        int k = log2(hi - low + 1);
        int left = st[low][k];
        int right = st[hi - (1 << k) + 1][k]; // đoạn có độ dài 2^k mà kết thúc ở [hi]

        return (a[left] <= a[right]) ? left : right;
    }

    public int log2(int n) {
        int log = 0;
        while(1 << (log + 1) <= n) log++;
        return log;
    }

    public void print(int [][]arr) {
        for(int i = 0; i < arr.length; ++i)
            System.out.println(Arrays.toString(arr[i]));
    }
}
