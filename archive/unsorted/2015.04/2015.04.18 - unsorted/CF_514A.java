package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;

public class CF_514A {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        char []a = in.next().toCharArray();
        int n = a.length;

        for(int i = 0; i < n; ++i) {
            int x = a[i] - '0', y = 9 - x;
            if(y < x) {
                if(i == 0) {
                    if (y > 0)
                        a[i] = (char) (y + '0');
                }
                else
                    a[i] = (char)(y + '0');
            }
        }

        out.println(new String(a));
    }
}
