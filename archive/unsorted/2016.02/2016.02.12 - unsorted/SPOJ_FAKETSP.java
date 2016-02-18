package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_FAKETSP {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int i = 0;
        double prev_x = 0, prev_y = 0, prev_d = 0;
        while(true) {
            String s;
            try {
                s = in.sl();
            } catch(Exception e) {return;}
            if(s == null) return;

            Matcher m = Pattern.compile("\\((.+)\\)").matcher(s);
            m.find();
            String ss = m.group(1);
            String[] xy = ss.split(",\\s");
            double x = Double.parseDouble(xy[0]), y = Double.parseDouble(xy[1]);

            if(i++ > 0) {
                prev_d += Math.sqrt(sqr(x - prev_x) + sqr(y - prev_y));
                out.printf("The salesman has traveled a total of %.3f kilometers.\n", prev_d);
            }
            prev_x = x;
            prev_y = y;
        }
    }

    double sqr(double x) {
        return x * x;
    }
}