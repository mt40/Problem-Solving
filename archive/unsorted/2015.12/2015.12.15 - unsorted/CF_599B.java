package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class CF_599B {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        String ans = "Possible";
        int n = in.nextInt(), m = in.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        int []a = new int[m], b = new int[m];
        boolean []amb = new boolean[n + 1];
        for(int i = 0; i < n; ++i) {
            int x = in.nextInt();
            if(map.containsKey(x) && map.get(x) <= m)
                amb[x] = true;
            map.put(x, i + 1);
        }
        for(int i = 0; i < m; ++i) b[i] = in.nextInt();

        for(int i = 0; i < m; ++i) {
            if(!map.containsKey(b[i])) {
                ans = "Impossible";
                break;
            }
            if(amb[b[i]]) {
                ans = "Ambiguity";
            }
            a[i] = map.get(b[i]);
        }

        out.println(ans);
        if(ans.equals("Possible")) {
            for(int i = 0; i < m; ++i)
                out.print(a[i] + " ");
        }
        out.println();
    }
}
