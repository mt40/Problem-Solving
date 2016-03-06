package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Stack;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_CTGAME {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i(), m = in.i();
        char [][]a = new char[n][m];
        for(int i = 0; i < n; ++i)
            for(int j = 0; j < m; ++j)
                a[i][j] = in.s().charAt(0);

        int [][]col = new int[n][m];
        for(int j = 0; j < m; ++j) {
            for(int i = n - 1; i >= 0; --i) {
                if(a[i][j] == 'F') {
                    col[i][j] = (i == n - 1) ? 1 : col[i+1][j] + 1;
                }
            }
        }

        int ans = 0;
        for(int i = 0; i < n; ++i) {
            int []hist = col[i];
            int area = cal(hist, m);
            ans = Math.max(area, ans);
        }

        out.println(ans*3);
    }

    int cal(int []hist, int n) {
        Stack<Integer> s = new Stack<>();
        int max_area = 0;
        int i = 0;
        while(i < n) {
            if(s.isEmpty() || hist[s.peek()] < hist[i])
                s.add(i++);
            else {
                int top = s.pop();
                int len = s.isEmpty() ? i : i - s.peek() - 1;
                int tmp_area = hist[top] * len;
                max_area = Math.max(tmp_area, max_area);
            }
        }
        while(!s.isEmpty()) {
            int top = s.pop();
            int len = s.isEmpty() ? i : i - s.peek() - 1;
            int tmp_area = hist[top] * len;
            max_area = Math.max(tmp_area, max_area);
        }
        return max_area;
    }
}