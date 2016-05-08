package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Random;

import helperClasses.FastScanner;
import helperClasses.Util;

/**
 * Given 2 arrays a & b with same length. You can swap position
 * of elements of a. You can also do that in array b.
 * Find the maximum sum of absolute difference of a_i and b_i
 * Original problem statement:
 * https://www.quora.com/How-do-I-maximize-the-sum-of-absolute-differences-at-corresponding-indices-of-two-arrays-over-all-their-possible-permutations?srid=zQg0
 */
public class MaxSumOfAbsDifference {
    int inf = Integer.MAX_VALUE;

    /**
     * The main idea to solve this is to realize that
     * the optimized solution is to sort a ascending and b descending
     * then calculate the sum.
     * Complexity: O(nlogn). Proof: just draw the cases on paper amd u'll see
     *
     * Tuy nhien, ta co the lam tot hon. Nhan xet thay trong
     * optimized solution (tuc a tang dan & b giam dan), ta thay rang
     * co vi tri i sao cho a[i-1] < b[i-1] va a[i] >= b[i] nhu vay
     * khi tinh sum thi tat ca so a[j] (j < i) khi bo dau gia tri tuyet
     * doi se co dau - phia truoc, nguoc lai voi cac so a[k] (k >= i).
     * Dieu nay dan den viec chi can tim dc i la se tinh dc sum nay`.
     * Va thuc chat i chinh la median cua array (a + b)
     */
    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        int []a = in.arr(n);
        int []b = in.arr(n);

        // Merge 2 arrays
        int []ab = new int[2 * n];
        System.arraycopy(a, 0, ab, 0, n);
        System.arraycopy(b, 0, ab, n, n);

        int low = kthSmallest(ab, n, 0, 2 * n - 1);
        int hi = kthSmallest(ab, n + 1, 0, 2 * n - 1);
        double median = (low + hi) / 2.0;

        int sum = 0;
        for(int i : ab) {
            if(i > median)
                sum += i;
            else
                sum -= i;
        }

        out.println(sum);
    }

    int kthSmallest(int []a, int k, int l, int r) {
        int pivotIdx = randomPartition(a, l, r);

        int pos = pivotIdx - l + 1;
        if(pos == k)
            return a[pivotIdx];
        else if(pos > k)
            return kthSmallest(a, k, l, pivotIdx - 1);
        return kthSmallest(a, k - pos, pivotIdx + 1, r);
    }

    int partition(int []a, int l, int r) {
        int pivot = a[r], i = l;
        for(int j = l; j <= r - 1; ++j) {
            if(a[j] <= pivot) {
                a[j] = swap(a[i], a[i] = a[j]);
                i++;
            }
        }
        a[r] = swap(a[i], a[i] = a[r]);
        return i;
    }

    int randomPartition(int []a, int l, int r) {
        int rand = getRandom(l, r);
        a[r] = swap(a[rand], a[rand] = a[r]);
        return partition(a, l, r);
    }

    // Called as follow: y = swap(x, x = y);
    int swap(int x, int y) {
        return x;
    }

    int getRandom(int low, int hi) {
        return new Random().nextInt(hi - low + 1) + low;
    }
}