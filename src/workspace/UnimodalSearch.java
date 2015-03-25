package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class UnimodalSearch {
    int n;
    int []a;
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        n = in.nextInt();
        a = new int[n];
        for(int i = 0; i < n; ++i)
            a[i] = in.nextInt();

        out.println(a[binSearch()]);
    }

    int binSearch() {
        int low = 0, hi = n - 1;
        while(low <= hi) {
            int mid = (low + hi) / 2;

            if((mid == 0 && a[mid] > a[mid + 1])
                    || (mid == n - 1 && a[mid - 1] < a[mid])
                    || (a[mid - 1] < a[mid] && a[mid] > a[mid + 1]))
                return mid;
            else if(a[mid - 1] < a[mid])
                low = mid + 1;
            else if(a[mid] > a[mid + 1])
                hi = mid - 1;
        }
        return -1;
    }
}
