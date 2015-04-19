package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class test2 {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int n = in.nextInt();
        int []A = new int[n];
        for(int i =0; i < n; ++i)
            A[i] = in.nextInt();

        long []sum = new long[n];
        sum[0] = A[0];
        for(int i = 1; i < n; ++i) {
            sum[i] = sum[i - 1] + A[i];
        }

        int ans = 0;
        for(int i = 0; i < n; ++i) {
            long left = 0, right = 0;
            if(i > 0) left = sum[i - 1];
            if(i < n - 1) right = sum[n - 1] - sum[i];
            if(left == right) {
                ans = i;
                break;
            }
        }

        out.println(ans);
    }
}
