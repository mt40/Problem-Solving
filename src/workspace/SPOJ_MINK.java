package workspace;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.io.PrintWriter;

public class SPOJ_MINK {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt(), k = in.nextInt();
        int []a = new int[n];
        for(int i = 0; i < n; ++i)
            a[i] = in.nextInt();

        Deque<Integer> window = new LinkedList<Integer>();
        for(int i = 0; i < n; ++i) {
            int x = a[i];
            while(window.size() > k)
                window.pollFirst();
            while(window.size() > 0 && window.peekLast() >= x)
                window.pollLast();
            window.add(x);

            if((i + 1) >= k)
                out.print(window.peekFirst() + " ");
        }

        out.println();
    }
}
