package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_SUBSUMS {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i(), a = in.i(), b = in.i();
        int []arr = in.arr(n);

        int len_l = n / 2, len_r = ((n & 1) > 0) ? n/2 + 1 : n / 2;
        int []left = genSubset(0, len_l, arr);
        int []right = genSubset(len_l, len_r, arr);

//        System.out.println(Arrays.toString(left));
//        System.out.println(Arrays.toString(right));

        Arrays.sort(right);

        long ans = 0;
        for(int i = 0; i < left.length; ++i) {
            int low = lower(right, a - left[i]);
            int hi = upper(right, b - left[i]);
            if(low <= hi && low >= 0)
                ans += hi - low + 1;
        }

        out.println(ans);
    }

    // smallest element >= key
    int lower(int []a, int key) {
        int low = 0, hi = a.length - 1, rs = -1;
        while(low <= hi) {
            int m = low + (hi - low) / 2;
            if(a[m] >= key){
                rs = m;
                hi = m - 1;
            }
            else low = m + 1;
        }
        return rs;
    }

    // biggest element <= key
    int upper(int []a, int key) {
        int low = 0, hi = a.length - 1, rs = -1;
        while(low <= hi) {
            int m = low + (hi - low) / 2;
            if(a[m] <= key) {
                rs = m;
                low = m + 1;
            }
            else hi = m - 1;
        }
        return rs;
    }

    int[] genSubset(int start, int len, int []a) {
        ArrayList<Integer> rs = new ArrayList<>();
        int sum;
        for(int mask = 0; mask < (1 << len); ++mask) {
            sum = 0;
            for(int i = 0; i < len; ++i)
                if((mask & (1 << i)) > 0)
                    sum += a[start + i];
            rs.add(sum);
        }

        int []tmp = new int[rs.size()];
        int id = 0;
        for(int rsi : rs) tmp[id++] = rsi;
        return tmp;
    }
}