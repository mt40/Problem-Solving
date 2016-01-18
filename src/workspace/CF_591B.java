package workspace;

import helperClasses.InputReader;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CF_591B {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        char[] a = in.next().toCharArray();

        Map<Character, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            char c = a[i];
            if (!map.containsKey(c))
                map.put(c, new ArrayList<Integer>());
            map.get(c).add(i);
        }

        while(m-- > 0) {
            char x = in.next().charAt(0);
            char y = in.next().charAt(0);
            if(x == y)
                continue;
            if(map.containsKey(x)) {
                map.put('$', map.get(x));
                map.remove(x);
            }
            if(map.containsKey(y)) {
                map.put(x, map.get(y));
                map.remove(y);
            }
            if(map.containsKey('$'))
                map.put(y, map.get('$'));
            map.remove('$');
        }

        for(Map.Entry<Character, ArrayList<Integer>> e : map.entrySet()) {
            for(int i : e.getValue()) {
                a[i] = e.getKey();
            }
        }

        out.println(String.valueOf(a));
    }
}
