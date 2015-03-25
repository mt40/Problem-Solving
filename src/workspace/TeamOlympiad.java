/**
 * Codeforces 490A
 */

package workspace;

import java.util.Scanner;
import java.io.PrintWriter;
import java.util.Stack;

public class TeamOlympiad {
    public Stack<Integer> Prog, Math, PE;
    public int N;

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        N = in.nextInt();
        Prog = new Stack<Integer>();
        Math = new Stack<Integer>();
        PE = new Stack<Integer>();

        for(int i = 0; i < N; ++i) {
            int subj = in.nextInt();
            if(subj == 1) Prog.push(i + 1);
            else if(subj == 2) Math.push(i + 1);
            else PE.push(i + 1);
        }

        int count = 0;
        String ans = "";
        while(Prog.size() > 0 && Math.size() > 0 && PE.size() > 0) {
            ans += "" + Prog.pop() + " " + Math.pop() + " " + PE.pop() + "\n";
            count++;
        }

        out.println(count);
        out.println(ans);
    }
}
