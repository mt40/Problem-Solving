package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class CuttingStick {
    int []arr;
    int N, L; // cuts & stick length

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        L = in.nextInt(); N = in.nextInt();
        arr = new int[N + 5];
        arr[0] = 0;
        for(int i = 1; i < N + 1; ++i) {
            arr[i] = in.nextInt();
        }
        arr[N + 1] = L;

        out.format("%d\n", cut(0, N + 1));
    }

    /**
     * DP approach: cost of cut(left, right) will be the cost of current length
     * plus cost of cutting (left, i) + (i, right)
     * cut(i - 1, i) = 0
     * cut(left, right) = min(cut(left, i) + cut(i, right) + (arr[right - arr[left])
     * i = [left + 1 ... right - 1];
     * @param left index of the outer left coordinate
     */
    public int cut(int left, int right) {
        if(left + 1 == right)
            return 0; // no cut in between
        int min = 1000000;
        int stickLength = arr[right] - arr[left];
        for(int i = left + 1; i < right; ++i) {
            int trial = cut(left, i) + cut(i, right) + stickLength;
            if(trial < min)
                min = trial;
        }
        return min;
    }
}
