package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;

public class CF_501A {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        int d = in.nextInt();

        double score1 = Math.max(0.3 * a, a - a * 1.0 / 250 * c);
        double score2 = Math.max(0.3 * b, b - b * 1.0 / 250 * d);

        out.println(score1 > score2 ? "Misha" : (score1 < score2 ? "Vasya" : "Tie"));
    }
}
