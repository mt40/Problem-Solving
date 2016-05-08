package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class Swap2Integers {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);

    }

    int swap(int a, int b) {
        return a;
    }

    void swap(IntHolder a, IntHolder b) {
        int tmp = a.value;
        a.value = b.value;
        b.value = tmp;
    }

    class IntHolder {
        int value;

        public IntHolder(int value) {
            this.value = value;
        }
    }
}