package workspace;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class sort_tmp {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int []a = new int[n];
        for(int i = 0; i < n; ++i)
            a[i] = in.nextInt();

        out.printf("Bubble sort: \t%s\n", arrToString(bubbleSort(a.clone())));
        out.printf("Insertion sort: %s\n", arrToString(insertionSort(a.clone())));
        out.printf("Selection sort: %s\n", arrToString(selectionSort(a.clone())));
        out.printf("Quick sort: \t%s\n", arrToString(quickSort(a.clone())));
        out.printf("Counting sort: \t%s\n", arrToString(countingSort(a.clone())));
        out.printf("Merge sort: \t%s\n", arrToString(mergeSort(a.clone())));
        out.printf("Radix sort: \t%s\n", arrToString(radixSort(a.clone())));
    }

    String arrToString(int []a) {
        String s = "";
        for(int i : a)
            s += i + " ";
        return s;
    }

    void swap(int []a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    int[] bubbleSort(int []a) {
        int n = a.length;

        boolean stop = true;
        do {
            stop = true;
            for(int i = 1; i < n; ++i) {
                if(a[i] < a[i - 1]) {
                    swap(a, i, i - 1);
                    stop = false;
                }
            }
        }
        while(stop == false);

        return a;
    }

    int[] insertionSort(int []a) {
        int n = a.length;

        for(int i = 0; i < n; ++i) {
            int j = i, x = a[i];
            while(j > 0 && a[j - 1] > x) {
                a[j] = a[j - 1];
                j--;
            }
            a[j] = x;
        }
        return a;
    }

    int[] selectionSort(int []a) {
        int n = a.length;

        for(int i = 0; i < n; ++i) {
            int min = i;
            for(int j = i + 1; j < n; ++j) {
                if(a[j] < a[min])
                    min = j;
            }
            swap(a, i, min);
        }

        return a;
    }

    int[] quickSort(int []a) {
        quickSort(a, 0, a.length - 1);
        return a;
    }

    void quickSort(int []a, int low, int hi) {
        int i = low, j = hi;
        int p = a[i + (j - i) / 2];
        while(i <= j) {
            while(a[i] < p) i++;
            while(a[j] > p) j--;
            if(i <= j) {
                swap(a, i, j);
                i++;
                j--;
            }
        }

        if(i <= hi) quickSort(a, i, hi);
        if(low <= j) quickSort(a, low, j);
    }

    int[] countingSort(int []a) {
        int n = a.length;

        int max = a[0];
        for(int i = 1; i < n; ++i)
            max = Math.max(a[i], max);

        int []f = new int[max + 1];
        for(int i = 0; i < n; ++i)
            f[a[i]]++;

        int j = 0;
        for(int i = 0; i < f.length; ++i) {
            while(f[i] > 0) {
                a[j] = i;
                j++;
                f[i]--;
            }
        }
        return a;
    }

    int[] mergeSort(int []a) {
        int n = a.length;
        if(n == 1) return a;

        int mid = n / 2;
        int []left = mergeSort(Arrays.copyOfRange(a, 0, mid));
        int []right = mergeSort(Arrays.copyOfRange(a, mid, n));
        int []merge = new int[n];

        int i = 0, j = 0, k = 0;
        while(i < left.length && j < right.length) {
            if(left[i] < right[j]) {
                merge[k] = left[i];
                i++;
            }
            else {
                merge[k] = right[j];
                j++;
            }
            k++;
        }

        while(i < left.length)
            merge[k++] = left[i++];
        while(j < right.length)
            merge[k++] = right[j++];

        return merge;
    }

    int[] radixSort(int []a) {
        int max = a[0];
        for(int i : a)
            max = Math.max(max, i);

        for(int e = 1; max / e >= 1; e *= 10)
            radixSort(a, e);
        return a;
    }

    void radixSort(int []a, int e) {
        int n = a.length;

        int []clone = a.clone();

        int []f = new int[9 + 1];
        for(int i = 0; i < n; ++i) {
            int digit = (a[i] / e) % 10;
            f[digit]++;
        }

        for(int i = 1; i <= 9; ++i) {
            f[i] += f[i - 1];
        }

        for(int i = n - 1; i >= 0; --i) {
            int digit = (a[i] / e) % 10;
            int pos = --f[digit];
            clone[pos] = a[i];
        }

        // copy back to 'a'
        for(int i = 0; i < n; ++i)
            a[i] = clone[i];
    }
}
