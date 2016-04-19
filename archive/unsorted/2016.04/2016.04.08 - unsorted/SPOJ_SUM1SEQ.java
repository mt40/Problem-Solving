package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_SUM1SEQ {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i(), sum = in.i();

        List<Integer> ans = new ArrayList<>();
        ans.add(0);
        int prev = 0, sign = sum;
        while(sum != 0) {
            int next = get(sum, prev);
            sum -= next;
            ans.add(next);
            prev = next;
        }

        if(sign >= 0)
            Collections.sort(ans);
        else
            Collections.sort(ans, Collections.reverseOrder());

        if(testNumber > 1)
            out.println();

        if(ans.size() > n)
            out.println("No");
        else {
            int dif = n - ans.size();
            while(dif-- > 0)
                out.println(0);
            for(int ai : ans)
                out.println(ai);

            int tmp = 0;
            for(int ai : ans)
                tmp += ai;
            if(tmp == sign)
                System.out.println("Correct!");
            else
                System.out.println("Incorrect!");
        }
    }

    int get(int sum, int prev) {
        if(sum < 0)
            return Math.max(prev - 1, sum);
        return Math.min(prev + 1, sum);
    }
}