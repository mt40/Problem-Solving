package workspace;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.PrintWriter;

public class WhatGoesUp {
    int N;
    int []arr;
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        N = in.nextInt();
        arr = new int[N + 3];

        for(int i = 0; i < N; ++i) {
            arr[i] = in.nextInt();
        }

        int ans = LIS();

        out.println(ans);
    }

    // same as LIS problem but use binary search to insert new number
    public int LIS() {
        List<Integer> lis = new ArrayList<Integer>();
        lis.add(arr[0]);
        int max = 0;

        for(int i = 1; i < N; ++i) {
            int tmp = binarySearch(lis, arr[i]);
            if(tmp >= 0)
                lis.set(tmp, arr[i]);
            else
                lis.add(arr[i]);
            if(lis.size() > max)
                max = lis.size();
        }

        return max;
    }

    /**
     * Search for position ...AB...
     * which A < k and k <= B
     */
    public int binarySearch(List<Integer> lis, int k) {
        int low = 0, hi = lis.size() - 1;

        while(low <= hi) {
            int mid = (low + hi) / 2;
            if(lis.get(mid) >= k && (mid == 0 || lis.get(mid - 1) < k)) {
                return mid;
            }
            else if(lis.get(mid) >= k)
                hi = mid - 1;
            else
                low = mid + 1;
        }

        return -1;
    }
}
