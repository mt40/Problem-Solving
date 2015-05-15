package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class CF_282C {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        char []a = in.next().toCharArray();
        char []b = in.next().toCharArray();

        String ans = "YES";
        if(a.length != b.length)
            ans = "NO";
        else {
            int n = a.length;
            boolean aHasOne = false, bHasOne = false;
            for(int i = 0; i < n; ++i)
                if(a[i] == '1')
                    aHasOne = true;
            for(int i = 0; i < n; ++i)
                if(b[i] == '1')
                    bHasOne = true;
            if(aHasOne != bHasOne)
                ans = "NO";
        }

        out.println(ans);
    }
}
