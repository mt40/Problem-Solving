package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class NextPermutation {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int []a = new int[n];
        for(int i = 0; i < n; ++i)
            a[i] = in.nextInt();

        int []next = nextPermutation(a);
        while(next != null) {
            out.println(arrString(next));
            next = nextPermutation(next);
        }
    }

    /**
     * Ý t??ng: ?i tìm k l?n nh?t sao cho a[k] < a[k + 1]
     * khi ?ó, ?o?n [k+1 : n-1] là gi?m d?n. Có ngh? là
     * ?o?n [k+1 : n-1] ?ã là l?n nh?t r?i, ko còn thay ??i dc gì trong
     * ?o?n này n?a. Do ?ó tìm r sao cho a[r] > a[k] (r ph?i xa k nh?t).
     * Swap a[k] & a[r], reverse ?o?n [k+1 : n-1] ?? dc ?o?n t?ng d?n.
     * ?ây chính là hoán v? k? ti?p. N?u ko tìm dc k, ?ây ?ã là hoán v? cu?i cùng.
     */
    int[] nextPermutation(int []a) {
        int k = -1, n = a.length;
        // find the largest k such that a[k] < a[k + 1]
        for(int i = 0; i < n - 1; ++i) {
            if(a[i] < a[i + 1])
                k = i;
        }
        if(k == -1) return null; // this is the last permutation
        // find the largest r such that a[k] < a[r]
        int r = k + 1;
        for(int i = k + 1; i < n; ++i) {
            if(a[i] > a[k])
                r = i;
        }

        swap(a, k, r);
        reverse(a, k + 1, n - 1);
        return a;
    }

    void swap(int []a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    void reverse(int []a, int l, int r) {
        for(int i = 0; i < r - l; ++i) {
            swap(a, l + i, r - i);
        }
    }

    String arrString(int []a) {
        String s = "";
        for(int x : a)
            s += x + " ";
        return s;
    }
}
