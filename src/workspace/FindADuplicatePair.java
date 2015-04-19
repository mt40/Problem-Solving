package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;

public class FindADuplicatePair {
    /**
     * Find a pair of 2 equal numbers in an array
     * of n different numbers from 1...n
     * Complexity: O(n)
     * Space: O(1) (no extra space)
     */
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int []arr = new int[n + 1];
        for(int i = 1; i <= n; ++i)
            arr[i] = in.nextInt();

        /**
         * ý tưởng: mình đánh dấu số đã visit bằng giá trị âm của nó
         * nếu số tại ô thứ x đã dc đánh dấu, thì nếu gặp arr[i] = x
         * ta lại visit ô thứ x 1 lần nữa, x chính là số lặp lại
         */
        for(int i = 1; i <= n; ++i) {
            int index = Math.abs(arr[i]);
            if(arr[index] > 0)
                arr[index] = -arr[index];
            else
                out.println(index);
        }
    }
}
