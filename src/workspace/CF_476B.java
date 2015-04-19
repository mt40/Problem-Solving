package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;

/**
 * Recursive solution
 */
public class CF_476B {
    int sol = 0;
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        char []a = in.next().toCharArray();
        char []b = in.next().toCharArray();
        int n = a.length;

        sol = 0;
        for(int i = 0; i < n; ++i)
            sol += (a[i] == '+')? 1 : -1;

        // Count unknowns
        int count = 0;
        for(int i = 0; i < n; ++i)
            if(b[i] == '?')
                count++;

        int total = 1 << count;
        cal(b, 0, 0);
        out.printf("%.12f", right * 1.0 / total);
    }

    int right = 0;
    void cal(char []arr, int cur, int val) {
        if(cur == arr.length) {
            if (val == sol)
                right++;
            return;
        }
        if(arr[cur] == '+')
            cal(arr, cur + 1, val + 1);
        else if(arr[cur] == '-')
            cal(arr, cur + 1, val - 1);
        else {
            // unknown ?
            cal(arr, cur + 1, val + 1);
            cal(arr, cur + 1, val - 1);
        }
    }
}
