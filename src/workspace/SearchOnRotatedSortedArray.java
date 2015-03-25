package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class SearchOnRotatedSortedArray {
    int n;
    int []a;
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        n = in.nextInt();
        a = new int[n];

        for(int i = 0; i < n; ++i)
            a[i] = in.nextInt();

        out.println(search(0, n - 1, 662));
    }
    int cnt = 1;
    int search(int low, int hi, int val) {
        System.out.println(cnt++ + " run"); // count how many runs
        if(low == hi) { // length = 1
            if(a[low] == val)
                return low;
            return -1; // not found
        }

        // divide into 2 parts
        int mid = (low + hi) / 2;
        if(isSorted(low, mid) && inRange(low, mid, val))
            return search(low, mid, val);
        if(isSorted(mid + 1, hi) && inRange(mid + 1, hi, val))
            return search(mid + 1, hi, val);
        if(!isSorted(low, mid))
            return search(low, mid, val);
        if(!isSorted(mid + 1, hi))
            return search(mid + 1, hi, val);
        return -1;
    }

    boolean inRange(int low, int hi, int val) {
        return (a[low] <= val && val <= a[hi]);
    }

    boolean isSorted(int low, int hi) {
        return a[low] <= a[hi];
    }
}
