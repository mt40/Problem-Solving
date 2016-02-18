package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;

public class CF_478A {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = 5;
        int sum = 0;
        for(int i = 0; i < n; ++i)
            sum += in.nextInt();

        if(sum % 5 == 0 && sum > 0)
            out.println(sum / 5);
        else
            out.println(-1);
    }
}
