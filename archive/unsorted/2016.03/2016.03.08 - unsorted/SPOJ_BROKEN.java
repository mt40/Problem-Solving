package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.*;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_BROKEN {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int m;
        while((m = in.i()) > 0) {
            char[] a = in.sl().toCharArray();
            int n = a.length;

            HashMap<Character, Integer> map = new HashMap<>();
            Queue<Character> queue = new LinkedList<>();
            int ans = 0;
            for (char ai : a) {
                add(map, queue, ai);
                while (map.size() > m)
                    remove(map, queue);
                ans = Math.max(queue.size(), ans);
            }

            out.println(ans);
        }
    }

    void add(Map<Character, Integer> map, Queue<Character> queue, char c) {
        if(map.containsKey(c))
            map.put(c, map.get(c) + 1);
        else
            map.put(c, 1);
        queue.add(c);
    }

    void remove(Map<Character, Integer> map, Queue<Character> queue) {
        char c = queue.poll();
        int cnt = map.remove(c) - 1;
        if(cnt > 0) map.put(c, cnt);
    }
}