package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Stack;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_MMAS {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        a = in.c();
        int n = a.length;

        Stack<Integer> stack = new Stack<>();
        closePos = new int[n];
        for(int i = 0; i < n; ++i) {
            if(a[i] == '(') stack.add(i);
            else if(a[i] == ')') {
                int openPos = stack.pop();
                closePos[openPos] = i;
            }
        }

        int ans = cal(0, n - 1);
        out.println(ans);
    }

    char []a;
    int []closePos;
    int cal(int l, int r) {
        int sum = 0, i = l;
        while(i <= r) {
            if(a[i] == '(') {
                int inner = cal(i + 1, closePos[i] - 1);
                i = closePos[i] + 1;
                if(i <= r && Character.isDigit(a[i])) {
                    inner *= (int) (a[i] - '0');
                    i++;
                }
                sum += inner;
            }
            else {
                int w = weight(a[i]);
                if(i < r && Character.isDigit(a[i + 1])) {
                    w *= (int) (a[i + 1] - '0');
                    i++;
                }
                sum += w;
                i++;
            }
        }
        return sum;
    }

    int weight(char c) {
        if(c == 'C') return 12;
        if(c == 'H') return 1;
        return 16;
    }
}