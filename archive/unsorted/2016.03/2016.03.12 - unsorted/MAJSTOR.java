package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class MAJSTOR {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int R = in.i();
        char []sven = in.c();
        int n = in.i();
        char [][]friends = in.c(n, R);

        Result []results = new Result[R];
        for(int i = 0; i < R; ++i) results[i] = new Result();
        for(int i = 0; i < n; ++i)
            for(int j = 0; j < R; ++j)
                results[j].add(friends[i][j]);

        int realScore = 0, maxScore = 0;
        for(int i = 0; i < R; ++i) {
            char me = sven[i];
            realScore += results[i].fight(me);

            int trial = Util.max(results[i].fight('P'), results[i].fight('S'), results[i].fight('R'));
            maxScore += trial;
        }

        out.println(realScore);
        out.println(maxScore);
    }

    char better(char c) {
        if(c == 'S') return 'R';
        else if(c == 'P') return 'S';
        return 'P';
    }

    class Result {
        int scissor, paper, rock;

        public Result() {}

        public Result(int scissor, int paper, int rock) {
            this.scissor = scissor;
            this.paper = paper;
            this.rock = rock;
        }

        void add(char c) {
            if(c == 'S') scissor++;
            else if(c == 'P') paper++;
            else rock++;
        }

        int fight(char c) {
            if(c == 'S') return paper*2 + scissor;
            else if(c == 'P') return rock*2 + paper;
            else return scissor*2 + rock;
        }
    }
}