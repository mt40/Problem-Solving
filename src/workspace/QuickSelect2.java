package workspace;

import java.util.Random;
import java.util.Scanner;
import java.io.PrintWriter;

public class QuickSelect2 {
    /**
     * Revisit the quickselect algorithm
     */
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt(), m = in.nextInt();
        int []a = new int[n];
        for(int i = 0; i < n; ++i)
            a[i] = in.nextInt();

        while(m-- > 0) {
            int k = in.nextInt();
            out.println(quickSelect(a.clone(), k));
        }
    }

    /**
     * Ý t??ng: ch?n 1 ph?n t? làm pivot, partition m?ng sao cho
     * thành 2 ?o?n left và right, left g?m các ptu <= pivot,
     * right g?m các ptu > pivot (t?c là y chang quicksort).
     * ??n ?ây g?i p là index n?m gi?a left và right.
     * Nh? v?y, t? 0->i là có i + 1 ptu <= pivot:
     * -- n?u i + 1 = k thì pivot là ?áp án
     * -- n?u i + 1 < k thì ?áp án n?m ? ?o?n right v?i k = k - (i + 1)
     * -- n?u i + 1 > k thì ?áp án n?m ? ?o?n left, k gi? nguyên
     */
    int quickSelect(int []a, int k) {
        int n = a.length, low = 0, hi = n - 1;
        return quickSelect(a, k, low, hi);
    }

    Random rand = new Random();
    int quickSelect(int []a, int k, int l, int r) {
        //int pivot = a[rand.nextInt(r + 1 - l) + l]; // UNSTABLE!
        int pivot = a[(r + l) / 2];
        int p = partition(a, pivot, l, r);
        if(p - l + 1 == k) // p - l + 1 = s? ptu <= pivot
            return pivot; // VERY IMPORTANT!
        if(p - l + 1 < k)
            return quickSelect(a, k - p + l - 1, p + 1, r);
        return quickSelect(a, k, l, p);
    }

    int partition(int []a, int p, int l, int r) {
        int i = l, j = r;
        while(i <= j) {
            while(a[i] < p) ++i;
            while(p < a[j]) --j;
            if(i <= j) {
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
                ++i; --j;
            }
        }
        int bound = l;
        for(int x = l + 1; x <= r; ++x) {
            if(a[x] > p) break;
            bound++;
        }
        return bound;
    }
}
