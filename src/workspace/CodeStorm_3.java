package workspace;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.io.PrintWriter;

public class CodeStorm_3 {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int []a = new int[n];
        for(int i = 0; i < n; ++i) {
            a[i] = in.nextInt();
        }

        long acute = 0, right = 0, obtuse = 0;
        for(int i = 0; i < n; ++i) {
            for(int j = i + 1; j < n; ++j) {
                int less = binSearch(a, j + 1, a[i] * a[i] + a[j] * a[j]);
                int larger = 0;
                if(less > 0) {
                    acute += less - j;
                    larger = less + 1;
                }
                int equal = binSearch2(a, j + 1, a[i] * a[i] + a[j] * a[j]);
                if(equal > 0) {
                    right += equal - Math.max(j, less);
                    larger = equal + 1;
                }
                larger = binSearch3(a, j + 1, a[i] + a[j]);
                if(larger > 0)
                    obtuse += larger - Math.max(less, Math.max(j, equal));
            }
        }

        out.printf("%d %d %d\n", acute, right, obtuse);
    }

    int binSearch3(int []a, int l, int x) {
        int low = l, hi = a.length - 1;
        int rs = -1;
        while(low <= hi) {
            int mid = low + (hi - low) / 2;
            if(x > a[mid]) {
                rs = mid;
                low = mid + 1;
            }
            else hi = mid - 1;
        }
        return rs;
    }

    int binSearch(int []a, int l, int x) {
        int low = l, hi = a.length - 1;
        int rs = -1;
        while(low <= hi) {
            int mid = low + (hi - low) / 2;
            if(x > a[mid] * a[mid]) {
                rs = mid;
                low = mid + 1;
            }
            else hi = mid - 1;
        }
        return rs;
    }

    int binSearch2(int []a, int l, int x) {
        int low = l, hi = a.length - 1;
        int rs = -1;
        while(low <= hi) {
            int mid = low + (hi - low) / 2;
            if(a[mid] * a[mid] == x) {
                rs = mid;
                low = mid + 1;
            }
            else if(a[mid] * a[mid] > x) hi = mid - 1;
            else low = mid + 1;
        }
        return rs;
    }
}
