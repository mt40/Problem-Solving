package workspace;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class PancakeSorting {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int []a = new int[n];
        for(int i = 0; i < n; ++i)
            a[i] = in.nextInt();

        pancakeSort(a);
        printArr(a, out);
    }

    void printArr(int []a, PrintWriter out) {
        for(int x : a)
            out.print(x + " ");
        out.println();
    }

    void pancakeSort(int []a) {
        int n = a.length, right = n - 1;
        for(int i = 0; i < n; ++i, --right) {
            int max = getMaxIndex(a, 0, right);
            // move max to head
            flip(a, 0, max);
            // move max to tail (but we avoid the larger element that was already
            // at the bottom)
            flip(a, 0, right);
        }
    }

    void flip(int []a, int left, int right) {
        int n = right - left + 1;
        for(int i = 0; i < n / 2; ++i) {
            int tmp = a[i + left];
            a[i + left] = a[right - i];
            a[right - i] = tmp;
        }
    }

    int getMaxIndex(int []a, int left, int right) {
        int max = left;
        for(int i = left + 1; i <= right; ++i) {
            max = (a[max] < a[i]) ? i : max;
        }
        return max;
    }
}
