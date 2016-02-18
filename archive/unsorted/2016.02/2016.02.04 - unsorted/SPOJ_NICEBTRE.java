package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Stack;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_NICEBTRE {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        char []a = in.c();
        int n = a.length;

        int ans = 0, cnt = 0;
        Stack<Character> s = new Stack<>();
        for(int i = 0; i < n; ++i) {
            if(a[i] == 'n') {
                s.push(a[i]);
                cnt++;
            }
            else {
                ans = Math.max(cnt, ans);
                s.push(a[i]);
                while(s.size() > 2 && (
                        s.peek() == 'l' && nextToTop(s) == 'l')) {
                    s.pop(); // pop 'l'
                    s.pop(); // pop 'l'
                    s.pop(); // pop 'n'
                    cnt--;
                    s.push('l');
                }
            }
        }

        out.println(ans);
    }

    <T>T nextToTop(Stack<T> s) {
        T top = s.pop();
        T rs = s.peek();
        s.push(top);
        return rs;
    }
}