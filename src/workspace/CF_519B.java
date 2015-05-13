package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class CF_519B {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Map<Integer, Integer> map2 = new HashMap<Integer, Integer>();
        Map<Integer, Integer> map3 = new HashMap<Integer, Integer>();

        read(map, n, in);
        read(map2, n - 1, in);
        read(map3, n - 2, in);

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();
            if(val - get(map3, key) >= 2) { // print this value 2 times
                out.printf("%d\n%d\n", key, key);
                return;
            }
        }

        int key1 = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();
            if(get(map2, key) < val) {
                out.println(key);
                key1 = key;
            }
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();
            if(get(map3, key) < val && key != key1) {
                out.println(key);
            }
        }
    }

    public int get(Map<Integer, Integer> map, int key) {
        if(map.containsKey(key))
            return map.get(key);
        return 0;
    }

    public void read(Map<Integer, Integer> map, int n, InputReader in) {
        for(int i = 0; i < n; ++i) {
            int x = in.nextInt();
            if(map.containsKey(x))
                map.put(x, map.get(x) + 1);
            else
                map.put(x, 1);
        }
    }
}
