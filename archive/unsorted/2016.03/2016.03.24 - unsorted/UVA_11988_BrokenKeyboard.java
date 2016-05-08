package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class UVA_11988_BrokenKeyboard {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        while (true) {
            char []a;
            try {
                a = in.c();
            }
            catch(Exception e) {
                return;
            }

            StringBuilder left = new StringBuilder();
            StringBuilder right = new StringBuilder();
            boolean flag = false;
            for(char c : a) {
                if(c == '[') {
                    flag = true;
                    concat(left, right);
                }
                else if(c == ']') {
                    flag = false;
                    concat(left, right);
                }
                else { // letters and underscore
                    if(flag)
                        left.append(c);
                    else
                        right.append(c);
                }
            }
            concat(left, right);

            out.println(right);
        }
    }

    void concat(StringBuilder left, StringBuilder right) {
        if(left.length() > 0)
            right.insert(0, left);
        left.delete(0, left.length());
    }
}