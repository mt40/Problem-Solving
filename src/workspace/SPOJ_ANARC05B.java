package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;

public class SPOJ_ANARC05B {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        while(true) {
            int n = in.nextInt();
            if(n == 0)  return;
            int []a = new int[n];
            for(int i = 0; i < n; ++i) a[i] = in.nextInt();
            int m = in.nextInt();
            int []b = new int[m];
            for(int i = 0; i < m; ++i) b[i] = in.nextInt();

            int []culA = new int[n];
            culA[0] = a[0];
            for(int i = 1; i < n; ++i)
                culA[i] = culA[i - 1] + a[i];

            int []culB = new int[m];
            culB[0] = b[0];
            for(int i = 1; i < m; ++i)
                culB[i] = culB[i - 1] + b[i];

            int i = 0, j = 0, k = 0, ans = 0;
            for(i = 0; i < m; ++i) {
                int pos = binSearch(a, b[i]);
                if(pos != -1) {
                    ans += Math.max(sum(a, culA, k, pos), sum(b, culB, j, i));
                    j = i;
                    k = pos;
                }
            }
            ans += Math.max(sum(a, culA, k, n - 1) + a[n - 1],
                    sum(b, culB, j, i - 1) + b[m - 1]);

            out.println(ans);
        }
    }

    int sum(int []a, int []cul, int i, int j) {
        return cul[j] - cul[i] + a[i] - a[j];
    }

    int binSearch(int []arr, int x) {
        int n = arr.length;
        int low = 0, hi = n - 1;
        while(low <= hi) {
            int mid = (low + hi) / 2;
            if(arr[mid] == x)
                return mid;
            else if(arr[mid] < x)
                low = mid + 1;
            else
                hi = mid - 1;
        }
        return -1;
    }
}
