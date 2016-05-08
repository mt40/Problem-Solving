package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_ACMT {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int experts = in.i(), newbies = in.i();

        int teams = 0;
        while(experts > 0 && newbies > 0) {
            if(experts > newbies) {
                experts -= 2;
                newbies -= 1;
                if(experts >= 0 && newbies >= 0)
                    teams++;
            }
            else {
                experts -= 1;
                newbies -= 2;
                if(experts >= 0 && newbies >= 0)
                    teams++;
            }
        }

        out.println(teams);
    }
}