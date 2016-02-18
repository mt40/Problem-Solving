package workspace;

import java.util.PriorityQueue;
import java.util.Scanner;
import java.io.PrintWriter;

public class CF_586B {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int []a1 = new int[n - 1];
        int []a2 = new int[n - 1];
        int []b = new int[n];
        for(int i = 0; i < n - 1; ++i) a1[i] = in.nextInt();
        for(int i = 0; i < n - 1; ++i) a2[i] = in.nextInt();
        for(int i = 0; i < n; ++i) b[i] = in.nextInt();

        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        for(int i = 0; i < n; ++i) {
            int time1 = sum(a1, 0, i);
            int time2 = sum(a2, i, n - 1);
            heap.add(time1 + time2 + b[i]);
        }

        out.println(heap.poll() + heap.poll());
    }

    int sum(int []arr, int l, int r) {
        int rs = 0;
        for(int i = l; i < r; ++i) {
            rs += arr[i];
        }
        return rs;
    }
}
