package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Random;

import helperClasses.FastScanner;
import helperClasses.Util;

public class QuickSelect2 {
    int inf = Integer.MAX_VALUE;
    Random rand = new Random();

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i(), k = in.i();
        int []a = in.arr(n);

        while(k-- > 0) {
            int k_th_smallest = quickSelect(a, in.i(), 0, n - 1);
            out.println(a[k_th_smallest]);
        }
    }

    /**
     * Implementation of Quick Select algo.
     * Worse case: O(n^2)
     * @return index of the k-th smallest element
     */
    int quickSelect(int []a, int k, int l, int r) {
        // Partition
        int pivotIdx = randomPartition(a, l, r);

        int pos = pivotIdx - l + 1;
        if(pos == k)
            return pivotIdx;
        else if(pos > k)
            return quickSelect(a, k, l, pivotIdx - 1);
        return quickSelect(a, k - pos, pivotIdx + 1, r);
    }

    /**
     * This is Lomuto's partition. It returns i such that
     * a[l...i-1] <= a[i] <= a[i+1...r]
     * We cannot use the original partition of Quick Sort
     * (a.k.a Hoare paritition) because it does not preserve
     * the index of the pivot (i.e nothing to return)
     */
    int partition(int []a, int l, int r) {
        int pivot = a[r], i = l;
        for(int j = l; j <= r - 1; ++j) {
            if(a[j] <= pivot) {
                a[j] = swap(a[i], a[i] = a[j]); // swap a[i] & a[j]
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

    /**
     * Get a random value between @low and @hi (both inclusive)
     */
    int getRandom(int low, int hi) {
        return rand.nextInt(hi - low + 1) + low;
    }

    int swap(int x, int y) {
        return x;
    }
}