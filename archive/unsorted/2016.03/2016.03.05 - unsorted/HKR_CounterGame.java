package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class HKR_CounterGame {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        long n = Long.parseUnsignedLong(in.s());

        long cnt = 0;
        while(n != 1) {
            if(Long.bitCount(n) == 1) // is power of 2
                n -= (n >> 1);
            else
                n -= smallerPowerOf2(n);
            cnt++;
        }

        if((cnt & 1) == 0) out.println("Richard");
        else out.println("Louise");
    }

    long smallerPowerOf2(long n) {
        return Long.highestOneBit(n);
    }
}