package workspace;

import java.util.*;
import java.io.PrintWriter;

public class CF_546D {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        Integer []primes = seive();
        // build a lookup array
        long []factors = new long[5000000 + 1];
        for(int i = 0; i < primes.length; ++i) {
            factors[primes[i]] = 1;
        }
        for(int i = 2; i < factors.length; ++i) {
            int num = i;
            if(factors[i] == 0) {
                for(int j = 0; j < primes.length; ++j) {
                    if(num % primes[j] == 0) {
                        int m = num / primes[j];
                        factors[i] = factors[m] + 1;
                        break;
                    }
                }
            }
        }

        long []cul = new long[5000000 + 1];
        for(int i = 2; i < cul.length; ++i) {
            cul[i] = cul[i - 1] + factors[i];
        }

        int T = in.nextInt();
        while(T-- > 0) {
            int a = in.nextInt();
            int b = in.nextInt();
            //System.out.printf("%d %d\n", cul[a], cul[b]);
            if(a == b)
                out.println(0);
            else
                out.println(cul[a] - cul[b]);
        }
    }

    Integer[] seive() {
        boolean []nums = new boolean[5000001];
        for(int i = 2; i < nums.length; ++i) {
            if(nums[i] == false) {
                for(int j = 2; j * i < nums.length; ++j) {
                    nums[j * i] = true;
                }
            }
        }

        List<Integer> temp = new LinkedList<Integer>();
        for(int i = 2; i < nums.length; ++i) {
            if(nums[i] == false)
                temp.add(i);
        }

        return temp.toArray(new Integer[temp.size()]);
    }
}
