package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class CF_574A {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int []v = new int[n];
        for(int i = 0; i < n; ++i)
            v[i] = in.nextInt();

        int count = 0;
        int max = max(v);
        while(max != 0) {
            v[0]++;
            v[max]--;
            max = max(v);
            count++;
        }

        out.println(count);
    }

    int max(int []a) {
        int max = 0;
        for(int i = 1; i < a.length; ++i)
            if(a[i] >= a[max])
                max = i;
        return max;
    }
}
