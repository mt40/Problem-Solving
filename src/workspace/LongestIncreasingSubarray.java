package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class LongestIncreasingSubarray {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int []a = new int[n];
        for(int i = 0; i < n; ++i)
            a[i] = in.nextInt();

        out.println(bruteForce(a));
        out.println(better(a));
    }

    /**
     * Obvious brute-force approach, complexity is O(n)
     */
    String bruteForce(int []a) {
        int n = a.length;
        int tmp_l = 0, l = 0, r = 0, max = 1, ans = 1;
        for(int i = 1; i < n; ++i) {
            if(a[i - 1] < a[i]) {
                max++;
                if(max > ans) {
                    ans = max;
                    r = i;
                    l = tmp_l;
                }
            }
            else {
                max = 1;
                tmp_l = i;
            }
        }

        return String.format("Answer is [%d : %d] with length %d", l, r, ans);
    }

    /**
     * If we find a valid substring with length L ending at i
     * we need to check for [i + 1 : i + L] from right to left,
     * if there is an invalid element, ignore the remaining indices
     */
    String better(int []a) {
        int n = a.length;
        int tmp_l = 0, l = 0, r = 0, tmp_ans = 1, ans = 1;
        for(int i = 1; i < n; ++i) {
            if(a[i - 1] < a[i]) {
                tmp_ans++;
                if(ans < tmp_ans) {
                    ans = tmp_ans;
                    l = tmp_l;
                    r = i;
                }
            }
            else if(i + tmp_ans - 1 < n) {
                int k = i + tmp_ans - 1;
                tmp_l = i;
                tmp_ans = 1;
                for(int j = k; j > i; --j) {
                    if(a[j - 1] < a[j]) {
                        tmp_ans++;
                    }
                    else {
                        tmp_l = j;
                        j = 0; // break
                    }
                }
                i = k; // continue from this position to save time
            }
        }
        return String.format("Answer is [%d : %d] with length %d", l, r, ans);
    }
}
