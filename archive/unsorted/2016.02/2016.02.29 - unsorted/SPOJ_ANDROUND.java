package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_ANDROUND {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i(), k = in.i();
        int []a = in.arr(n);
        k = Math.min(k, n);

        int highest = 0; // position of the highest 1 bit
        for(int ai : a)
            if(ai > 0)
                highest = Math.max(Integer.numberOfTrailingZeros(Integer.highestOneBit(ai)) + 1, highest);
        if(highest > 0) {
            Updater []b = new Updater[highest];
            int [][]save = new int[highest][n];

            // separate the each bit of each number
            for(int i = 0; i < highest; ++i) {
                int mask = 1 << i;
                for(int j = 0; j < n; ++j)
                    if ((a[j] & mask) > 0)
                        save[i][j] = 1;
                b[i] = new Updater(save[i]);
            }

            // work on them independently
            // expand 0s right k bits and left k bits
            for(int i = 0; i < highest; ++i) {
                for(int j = 0; j < n; ++j) {
                    if(save[i][j] == 0) { // is zero?
                        int left = Math.max(j - k, 0);
                        int right = Math.min(j + k, n - 1);

                        b[i].addUpdate(j, right);
                        int remain = k - (right - j);
                        if(remain > 0) b[i].addUpdate(0, remain - 1);

                        b[i].addUpdate(left, j);
                        remain = k - (j - left);
                        if(remain > 0) b[i].addUpdate(n - remain, n - 1);
                    }
                }
                b[i].validate();
            }

            // clear old values
            for(int i = 0; i < n; ++i) a[i] = 0;

            // merge
            for(int i = 0; i < highest; ++i) {
                for(int j = 0; j < n; ++j) {
                    int bit = b[i].src[j] << i;
                    a[j] |= bit;
                }
            }
        }

        for(int i = 0; i < n; ++i)
            out.print((i < n - 1) ? a[i] + " " : a[i]);
        out.println();
    }

    class Updater {
        int []src, cache;

        public Updater(int[] src) {
            this.src = src;
            cache = new int[src.length];
        }

        // -1 from l to r
        void addUpdate(int l, int r) {
            int v = r - l + 1;
            addAt(l, -v);
            addAt(r + 1, v);
        }

        void addAt(int id, int v) {
            if(id >= src.length) return; // ignore
            cache[id] += v;
        }

        // apply updates
        void validate() {
            int cur = 0;
            for(int i = 0; i < src.length; ++i) {
                cur += cache[i];
                src[i] += cur;
                src[i] = clamp(src[i], 0, 1);
            }
        }
    }

    int clamp(int x, int min, int max) {
        return (x < min)
                ? min
                : (x > max) ? max : x;
    }
}