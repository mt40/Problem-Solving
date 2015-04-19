package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class CF_431B {
    int []a = {0, 1, 2, 3, 4};
    int [][]hp;
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        hp = new int[5][5];
        for(int i = 0; i < 5; ++i)
            for(int j = 0; j < 5; ++j)
                hp[i][j] = in.nextInt();

        /**
         * Idea: bruteforce, test all permutation
         */
        P(new int[5], new int[5], 0);
        out.println(ans);
    }

    int ans = 0;
    void P(int []arr, int []visit, int cur) {
        if(cur == arr.length) {
            // we have one permutation here
            int happy = 0;
            for(int i = 0; i < 4; ++i)
                happy += hp[arr[i]][arr[i + 1]] + hp[arr[i + 1]][arr[i]];
            happy += hp[arr[2]][arr[3]] + hp[arr[3]][arr[2]];
            happy += hp[arr[3]][arr[4]] + hp[arr[4]][arr[3]];
            if(happy > ans)
                ans = happy;
            return;
        }
        for(int i = 0; i < arr.length; ++i) {
            if (visit[i] == 0) {
                visit[i] = 1;
                arr[cur] = a[i];
                P(arr, visit, cur + 1);
                visit[i] = 0;
            }
        }
    }
}
