package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class UnionOfSortedArrays {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt(), m = in.nextInt();
        int []a = new int[n], b = new int[m];
        for(int i = 0; i < n; ++i) a[i] = in.nextInt();
        for(int i = 0; i < m; ++i) b[i] = in.nextInt();

        Integer []union = new Integer[n + m];
        int i = 0, j = 0, k = 0;
        while(i < n && j < m) {
            if(a[i] == b[j]) {
                union[k++] = a[i];
                ++i; ++j;
            }
            else if(a[i] < b[j]) {
                union[k++] = a[i];
                ++i;
            }
            else {
                union[k++] = b[j];
                ++j;
            }
        }
        // add the remaining elements
        while(i < n) union[k++] = a[i++];
        while(j < m) union[k++] = b[j++];

        for(Integer x : union) {
            if(x != null)
                out.print(x + " ");
        }
        out.println();
    }
}
