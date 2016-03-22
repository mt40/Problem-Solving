package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.*;

import helperClasses.FastScanner;

public class CF_644C {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        HashMap<String, TreeSet<String>> map = new HashMap<>();
        for(int i = 0; i < n; ++i) {
            String s = in.s();
            int id = findSlash3(s);
            String host = s.substring(0, id);
            String path = s.substring(id);
            if(path.length() == 0) path = "@"; // safety...
            add(map, host, path);
        }

        HashMap<String, ArrayList<String>> rs = new HashMap<>();
        for(Map.Entry<String, TreeSet<String>> e : map.entrySet()) {
            Set<String> set = e.getValue();
            StringBuilder sb = new StringBuilder();
            for(String si : set)
                sb.append(si);

            String key = sb.toString();
            if(!rs.containsKey(key)) rs.put(key, new ArrayList<>());
            rs.get(key).add(e.getKey());
        }

        StringBuilder sb = new StringBuilder();
        int ans = 0;
        for(Map.Entry<String, ArrayList<String>> e : rs.entrySet()) {
            List<String> list = e.getValue();
            if(list.size() > 1) {
                ans++;
                for (String li : list)
                    sb.append(li).append(" ");
                sb.append("\n");
            }
        }

        out.println(ans);
        out.print(sb.toString());
    }

    int findSlash3(String s) {
        char []a = s.toCharArray();
        int i;
        for(i = 7; i < a.length; ++i)
            if (a[i] == '/')
                break;
        return i;
    }

    void add(HashMap<String, TreeSet<String>> map, String host, String path) {
        if(map.containsKey(host))
            map.get(host).add(path);
        else {
            TreeSet<String> list = new TreeSet<>();
            list.add(path);
            map.put(host, list);
        }
    }
}