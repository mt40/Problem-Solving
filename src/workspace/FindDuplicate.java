package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class FindDuplicate {
    /**
     * Given an array of n elements from 1->n
     * But there is 1 element missing and 1 duplicate
     * find those 2 elements
     */
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int []a = new int[n];
        for(int i = 0; i < n; ++i)
            a[i] = in.nextInt();

        /**
         * Y tuong: goi m la ptu thieu, d la ptu lap lai
         * Neu ta xor tat ca cac so tu 1->n va a[0..n-1]
         * thi se dc m^d (m xor d). Vi m != d nen se co 1
         * bit nao do = 1. Goi vi tri cua bit do la i.
         * Ta lai xor tat ca so tu 1->n va a[0..n-1] ma co bit i
         * = 1, goi ket qua la x. X chi co the la m hoac d.
         * Neu tim thay x trong a thi x la d.
         */

        int dup_XOR_miss = 0;
        for(int i = 0; i < n; ++i) {
            dup_XOR_miss ^= (i + 1) ^ a[i];
        }

        int diff = dup_XOR_miss & (~(dup_XOR_miss - 1));
        int miss_or_dup = 0;
        for(int i = 0; i < n; ++i) {
            if((a[i] & diff) > 0) {
                miss_or_dup ^= a[i];
            }
            if(((i + 1) & diff) > 0) {
                miss_or_dup ^= (i + 1);
            }
        }

        int miss = 0, dup = 0;
        for(int i = 0; i < n; ++i) {
            if(a[i] == miss_or_dup) {
                dup = miss_or_dup;
                break;
            }
        }
        if(dup == 0) {
            miss = miss_or_dup;
            dup = dup_XOR_miss ^ miss;
        }
        else
            miss = dup_XOR_miss ^ dup;
        out.printf("%d %d\n", dup, miss);
    }
}
