package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class SPOJ_SBANK {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        Map<String, Integer> m = new TreeMap<String, Integer>();
        for(int i = 0; i < n; ++i) {
            String key = in.nextLine();
            if(m.containsKey(key))
                m.put(key, m.get(key) + 1);
            else
                m.put(key, 1);
        }

        Iterator it = m.entrySet().iterator();
        while(it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            out.format("%s %d\n", entry.getKey(), entry.getValue());
        }
        out.println();
    }
}
