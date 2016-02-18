package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class TaskCF_599C {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int []a = new int[n];
        for(int i = 0; i < n; ++i) a[i] = in.nextInt();

        int []asc = a.clone();
        boolean []used = new boolean[n];
        Arrays.sort(asc);
        int ans = 1, l = 0, cur_max = -1;
        for(int i = 0; i < n; ++i) {
            if(l > 0 && l < n && cur_max <= asc[l]) {
                cur_max = -1;
                ans++;
            }
            cur_max = Math.max(cur_max, a[i]);
            int pos = find(asc, used, a[i]);
            used[pos] = true; // mark as used
            while(l < n && used[l]) l++;
        }

        out.println(ans);
    }

    int find(int []a, boolean []used, int key) {
        int rs = 0;
        int l = 0, r = a.length - 1;
        while(l <= r) {
            int m = l + (r - l) / 2;
            if(a[m] == key) {
                if(!used[m]) {
                    rs = m;
                    r = m - 1;
                }
                else
                    l = m + 1;
            }
            else if(a[m] > key)
                r = m - 1;
            else
                l = m + 1;
        }
        return rs;
    }
}
