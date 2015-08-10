package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class CF_121A {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int l = in.nextInt();
        int r = in.nextInt();

        List<Long> list = new ArrayList<Long>();
        for(int len = 1; len <= 10; ++len) {
            gen(list, len, 0);
        }

        long x = l, ans = 0;
        for(int i = 0; i < list.size(); ++i) {
            if(list.get(i) >= x) {
                long len = Math.min(list.get(i) - x + 1, r - x + 1);
                ans += len * list.get(i);
                x += len;
                if(x > r)
                    break;
            }
        }

        out.println(ans);
    }

    void gen(List<Long> list, int len, long num) {
        if(len == 0) {
            list.add(num);
            return;
        }
        gen(list, len - 1, num * 10 + 4);
        gen(list, len - 1, num * 10 + 7);
    }
}
