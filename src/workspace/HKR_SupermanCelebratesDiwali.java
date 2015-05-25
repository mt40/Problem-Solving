package workspace;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class HKR_SupermanCelebratesDiwali {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int N = in.nextInt();
        int H = in.nextInt();
        int I = in.nextInt();
        int []count = new int[N + 1];
        int [][]people = new int[N + 1][H + 1]; // number of people on floor j of building i
        for(int i = 1; i <= N; ++i) {
            count[i] = in.nextInt();
            for(int j = 0; j < count[i]; ++j) {
                int floor = in.nextInt();
                people[i][floor]++;
            }
        }

        /**
         * ý t??ng: dp(i,j) = s? ng c?u ???c t?i nhà i, t?ng j
         * ?i t? trên xu?ng (t?c t? H v? 1)
         * dp(i,j) = max(?i t? 1 t?ng trên c?a nhà hi?n t?i, nh?y t? nhà khác sang)
         * ?? ti?t ki?m cho v? 2 thì l?u s?n giá tr? max t?i t?ng x vào m?ng prev
         */

        int [][]dp = new int[N + 1][H + 1];
        int []prev = new int[H + 1];
        // base case
        for(int i = 1; i <= N; ++i) {
            dp[i][H] = people[i][H];
            prev[H] = Math.max(dp[i][H], prev[H]);
        }

        for(int j = H - 1; j > 0; --j) {
            for(int i = 1; i <= N; ++i) {
                dp[i][j] = dp[i][j + 1] + people[i][j];
                if(j + I <= H)
                    dp[i][j] = Math.max(prev[j + I] + people[i][j], dp[i][j]);
                prev[j] = Math.max(dp[i][j], prev[j]);
            }
        }

//        for(int i = 1; i <= N; ++i)
//            System.out.println(Arrays.toString(dp[i]));

        int ans = 0;
        for(int i = 1; i <= N; ++i)
            ans = Math.max(dp[i][1], ans);

        out.println(ans);
    }
}
