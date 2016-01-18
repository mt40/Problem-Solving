package workspace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.PrintWriter;
import helperClasses.ShortScanner;
import helperClasses.Util;

public class SPOJ_ASSIST {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, Scanner input, PrintWriter out) {
        ShortScanner in = new ShortScanner(input);
        int n;
        List<Integer> list = getNum(40000);

        while((n = in.i()) > 0) {
            out.println(list.get(n - 1));
        }
    }

    List<Integer> getNum(int mx) {
        List<Integer> primes = new ArrayList<>();
        boolean []sieve = new boolean[mx + 1];
        Arrays.fill(sieve, true);
        sieve[0] = sieve[1] = false;
        for (int i = 2; i <= mx; ++i) {
            if (!sieve[i]) continue;
            for (int j = i + 1, cnt = 0; j <= mx; j += 1) {
                if (sieve[j]) cnt++;
                if (cnt == i) {
                    sieve[j] = false;
                    cnt = 0;
                }
            }
        }
        for (int i = 0; i < sieve.length; ++i) if (sieve[i]) primes.add(i);
        return primes;
    }
}
