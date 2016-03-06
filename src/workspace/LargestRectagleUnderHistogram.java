package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Stack;

import helperClasses.FastScanner;
import helperClasses.Util;

public class LargestRectagleUnderHistogram {
    int inf = Integer.MAX_VALUE;

    /**
     * Largest rectangle under a histogram
     * ref: http://www.geeksforgeeks.org/largest-rectangle-under-histogram
     */
    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        int []histogram = in.arr(n);

        int ans = cal(histogram, n);

        out.println(ans);
    }

    int cal(int []his, int n) {
        Stack<Integer> s = new Stack<>();
        int max_area = 0, top, area_with_top;

        int i = 0;
        while(i < n) {
            if(s.isEmpty() || his[s.peek()] < his[i])
                s.add(i++);
            else {
                top = s.pop();
                int len = s.isEmpty() ? i : i - s.peek() - 1;
                area_with_top = his[top] * len;
                max_area = Math.max(area_with_top, max_area);
            }
        }
        // Pop remaining bars
        while(!s.isEmpty()) {
            top = s.pop();
            int l = s.isEmpty() ? i : i - s.peek() - 1;
            area_with_top = his[top] * l;
            max_area = Math.max(area_with_top, max_area);
        }
        return max_area;
    }
}