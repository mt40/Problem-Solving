package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class SPOJ_SAMER08F {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int []dp = new int[101];
        for(int i = 1; i <= 100; ++i)
            dp[i] = i * i + dp[i - 1];

        // Idea:
        // Số cách chọn k ô vuông liên tiếp trên 1 hàng là n - k + 1
        // Số cách chọn k ô vuông liên tiếp trên 1 cột là n - k + 1
        // Vậy với size k < n thì có tất cả (n - k + 1)^2 cách
        // Làm như v từ size k = 1 ... (n - 1), n
        while(true) {
            int n = in.nextInt();
            if(n == 0) return;

            out.println(dp[n]);
        }
    }
}
