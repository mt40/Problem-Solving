package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.BitSet;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_EMTY2 {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        String s = in.sl();
        char []num = s.toCharArray();

        int one = 0, zero = 0;
        boolean flag = false, ans = true;
        for(char c : num) {
            if(c == '0') {
                if(flag) {
                    one--;
                    if(one < 0) ans = false;
                    flag = false;
                    zero--;
                }
                else {
                    flag = true;
                    zero++;
                }
            }
            else
                one++;
        }
        if(one + zero != 0)
            ans = false;

        out.printf("Case %d: ", testNumber);
        if(ans)
            out.println("yes");
        else
            out.println("no");
    }
}