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
     * Y tuong: tim k lon nhat sao cho a[k] < a[k+1]
     * khi do, doan [k+1 : n-1] la giam dan. Co nghia la doan [k+1 : n-1] da tao thanh
     * 1 so lon nhat roi, ko con thay doi dc gi trong doan do nua. Sau do ta tim r sao
     * cho a[r] > a[k] (voi r-k lon nhat co the). Swap a[k] & a[r], reverse doan
     * [k+1 : n-1] (tuc bien no thanh doan tang dan).
     * Neu ban dau khong tim dc so k thi co nghia day da la permutation lon nhat roi.
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
