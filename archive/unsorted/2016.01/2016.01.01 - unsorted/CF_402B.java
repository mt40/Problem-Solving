package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.PriorityQueue;

public class CF_402B {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int []a = new int[n];
        for(int i = 0; i < n; ++i) a[i] = in.nextInt();

        int plus = -1, minus = -1, max_len = 1, len = 1, prev = 0; // prev=1: plus, -1:minus
        for(int i = 1; i < n; ++i) {
            if(a[i] > a[i - 1]) {
                if(prev == 1) { // the range ends here
                    len = i - plus;
                }
                plus = i;
                prev = 1;
            }
            else if(a[i] < a[i - 1]) {
                if(prev == -1) { // the range ends here
                    len = i - minus;
                }
                minus = i;
                prev = -1;
            }
            len++;
            max_len = Math.max(len, max_len);
        }

        out.println(max_len);
    }
}
