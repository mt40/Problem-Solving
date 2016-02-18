package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_SBETS {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = 16;
        HashMap<String, Integer> map = new HashMap<>();
        HashSet<String> lose = new HashSet<>();
        while(n-- > 0) {
            String a = in.s(), b = in.s();
            int goal_a = in.i(), goal_b = in.i();
            if(goal_a > goal_b) {
                add(map, a);
                lose.add(b);
            }
            else {
                add(map, b);
                lose.add(a);
            }
        }

        for(Map.Entry<String, Integer> e : map.entrySet()) {
            if(e.getValue() == 4 && !lose.contains(e.getKey())) {
                out.println(e.getKey());
                return;
            }
        }
    }

    void add(HashMap<String, Integer> map, String x) {
        if(map.containsKey(x))
            map.put(x, map.get(x) + 1);
        else map.put(x, 1);
    }
}