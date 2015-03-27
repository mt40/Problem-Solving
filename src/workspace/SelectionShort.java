package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;

public class SelectionShort {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int []a = new int[n];
        for(int i = 0; i < n; ++i)
            a[i] = in.nextInt();

        for(int i = 0; i < n; ++i) {
            int min = i;
            for(int j = i + 1; j < n; ++j)
                if(a[j] < a[min])
                    min = j;
            //swap
            int tmp = a[i];
            a[i] = a[min];
            a[min] = tmp;
        }

        //output
        for(int i = 0; i < n; ++i)
            out.print(a[i] + " ");
        out.println();
    }
}
