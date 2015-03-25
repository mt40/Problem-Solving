/** Problem URL
 * http://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=1884
 */
package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class HowDoYouAdd {
    int N, K;

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        N = in.nextInt(); K = in.nextInt();

        out.println(ways(N, K));
    }

    public int ways(int n, int k) {
        if(k == 1) return 1;
        int total = 0;
        for(int i = 0; i <= N; ++i) {
            total += ways(n - i, k - 1);
        }
        return total;
    }
}
