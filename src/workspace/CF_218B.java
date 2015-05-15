package workspace;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class CF_218B {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        Integer []p = new Integer[m]; // planes
        for(int i = 0; i < m; ++i)
            p[i] = in.nextInt();

        // Max
        Integer []p1 = p.clone();
        Arrays.sort(p1);
        int max = 0;
        for(int i = 0; i < n; ++i) {
            max += p1[m - 1];
            p1[m - 1]--;
            Arrays.sort(p1);
        }

        // Min
        Integer []p2 = p.clone();
        Arrays.sort(p2);
        int min = 0;
        int j = 0;
        for(int i = 0; i < n; ++i) {
            if(n - i < p2[j]) { // not enough people
                for(int k = 0; k < n - i; ++k)
                    min += p2[j] - k;
            }
            else
                min += p2[j] * (p2[j] + 1) / 2;
            i += p2[j] - 1;
            j++;
        }

        out.println(max + " " + min);
    }
}
