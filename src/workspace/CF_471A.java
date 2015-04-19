package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;

public class CF_471A {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = 6, leg = -1, sum = 0;
        int []a = new int[n];
        int []f = new int[10]; // range of value: 1 - 9

        for(int i = 0; i < n; ++i) {
            a[i] = in.nextInt();
            f[a[i]]++;
            if(f[a[i]] >= 4)
                leg = a[i];

            sum += a[i];
        }

        if(leg > 0) {
            if(f[leg] == 6) // all are the same
                out.println("Elephant");
            else {
                int x = 0, y = 0;
                for(int i = 0; i < n; ++i)
                    if(a[i] != leg) {
                        x = a[i];
                        break;
                    }
                y = sum - x - 4 * leg;
                if(x == y)
                    out.println("Elephant");
                else
                    out.println("Bear");
            }
        }
        else
            out.println("Alien");
    }
}
