package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

// Algorithm
// http://www.cs.utexas.edu/users/moore/best-ideas/mjrty/index.html
public class MajorityElement {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        char []a = new char[n];

        for(int i = 0; i < n; ++i)
            a[i] = in.next().charAt(0);

        char cur = '$';
        int count = 0;
        for(int i = 0; i < n; ++i) {
            if(count == 0) {
                cur = a[i];
                count++;
            }
            else {
                if (a[i] == cur)
                    count++;
                else
                    count--;
            }
        }

        // re-check
        int count2 = 0;
        for(int i = 0; i < n; ++i)
            if(a[i] == cur)
                count2++;
        if(count2 > n / 2)
            out.println(cur);
        else
            out.println("No");
    }
}
