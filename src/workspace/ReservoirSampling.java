package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Random;

import helperClasses.FastScanner;
import helperClasses.Util;

/**
 * Suppose we want to select k elements in the array of N
 * elements without knowing N (or N is too large to store
 * the whole array in the memory)
 * ref:
 * - https://www.wikiwand.com/en/Reservoir_sampling#
 * - https://www.quora.com/What-are-some-of-the-best-algorithms/answer/Jessica-Su?srid=zQg0
 */
public class ReservoirSampling {
    int inf = Integer.MAX_VALUE;
    Random rand = new Random();

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int k = in.i(); // N must be >= k

        // Initialize result array
        // At the beginning, we choose the first k elements
        int []reservoir = new int[k + 1];
        for(int i = 1; i <= k; ++i)
            reservoir[i] = in.i();

        // Process the remaining numbers (from k + 1 to N)
        int idx = k + 1;
        while(true) {
            int next;
            try {
                next = in.i();
            }
            catch (Exception e) {break;}

            // Get a random number in range [1..idx]
            int r = getRandom(1, idx);

            if(r <= k) {
                reservoir[r] = next;
            }
        }

        out.printf("%d randomly selected elements:\n", k);
        for(int i = 1; i <= k; ++i)
            out.print(reservoir[i] + " ");
        out.println();
    }

    /**
     * Return a random number between @low (inclusive)
     * and @hi (inclusive)
     */
    int getRandom(int low, int hi) {
        return low + rand.nextInt(hi - low + 1);
    }
}