package workspace;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class BinarySearchInCircleArray {
    /**
     * Binary search for sorted circular array
     * NOTE:
     * - Array elements must be distinct
     * - If not, the complexity is O(n) i.e. impossible to do binary search
     */
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt(), m = in.nextInt();
        int []a = new int[n];
        for(int i = 0; i < n; ++i)
            a[i] = in.nextInt();

        while(m-- > 0) {
            out.println(binSearch(a, 0, a.length - 1, in.nextInt()));
        }
    }

    /**
     * Idea:
     * - Either [low..mid] or [mid..hi] is sorted
     * - For each part: check if it is sorted
     *   - If so, check if it contains @key
     *      - If it does, just binary search (because this part is sorted)
     *   - Else, @key is in the other half, (can be sorted or un-sorted, we don't care)
     *   recur on the other half.
     * - If reach here, not found.
     */
    int binSearch(int []a, int low, int hi, int key) {
        if(low > hi)
            return -1;
        int mid = low + (hi - low) / 2;
        if(a[low] <= a[mid]) { // [low..mid] is sorted
            if(a[low] <= key && key <= a[mid])
                return Arrays.binarySearch(a, low, mid + 1, key);
            return binSearch(a, mid + 1, hi, key);
        }
        if(a[mid] < a[hi]) { // [mid..hi] is sorted
            if(a[mid] <= key && key <= a[hi])
                return Arrays.binarySearch(a, mid, hi + 1, key);
            return binSearch(a, low, mid - 1, key);
        }
        return -1;
    }
}
