package workspace;

import java.util.Collections;
import java.util.Scanner;
import java.io.PrintWriter;

public class GenericMax {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int []a = new int[n];
        for(int i = 0; i < n; ++i)
            a[i] = in.nextInt();

        out.println(_max(a[0], a[1], a[2]));
    }

    public <T extends Comparable<T>> T _max(T ... items) {
        T max = items[0];
        for(int i = 0; i < items.length; ++i)
            if(items[i].compareTo(max) > 0) max = items[i];
        return max;
    }
}
