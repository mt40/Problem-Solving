package workspace;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class CF_425A {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        int []a = new int[n];
        for(int i = 0; i < n; ++i) {
            a[i] = in.nextInt();
        }

        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < n; ++i) {
            int []clone = a.clone();
            int cnt = 0, neg = 0;
            int hi = i;
            for(hi = i; hi < n && neg <= k; ++hi) {
                neg += (clone[hi] < 0) ? 1 : 0;
            }

            for(int j = i; j < hi; ++j) {
                if(clone[j] < 0) {
                    int max = -1;
                    for (int m = 0; m < n; ++m) {
                        if (m < i || m >= hi) {
                            if (max == -1 || clone[m] > clone[max]) {
                                max = m;
                            }
                        }
                    }
                    if(max > 0)
                        swap(clone, j, max);
                }
            }

            // culmulative sum
            int []cul = new int[n + 1];
            for(int j = 1; j <= n; ++j)
                cul[j] = cul[j - 1] + clone[j - 1];

            for(int l = 1; l <= n; ++l) {
                for(int r = l; r <= n; ++r) {
                    ans = Math.max(cul[r] - cul[l - 1], ans);
                }
            }

        }

        /**
         * Remember to check if all elements are negative
         * if so, pick the biggest one
         */
        boolean isAllNeg = true;
        for(int i : a) {
            if(i >= 0)
                isAllNeg = false;
        }

        if(isAllNeg) {
            int max = a[0];
            for(int i : a) {
                max = Math.max(i, max);
            }
            ans = max;
        }

        out.println(ans);
    }

    void swap(int []arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
