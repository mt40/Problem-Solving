package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class CF_501B {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();

        Map<String, String> dict = new HashMap<String, String>();
        for(int i = 0; i < n; ++i) {
            String a = in.next();
            String b = in.next();

            if(dict.containsValue(a)) {
                for (Map.Entry<String, String> entry : dict.entrySet()) {
                    if (entry.getValue().equals(a))
                        entry.setValue(b);
                }
            }
            else
                dict.put(a, b);
        }

        out.println(dict.size());
        for(Map.Entry<String, String> entry : dict.entrySet())
            out.printf("%s %s\n", entry.getKey(), entry.getValue());
    }
}
