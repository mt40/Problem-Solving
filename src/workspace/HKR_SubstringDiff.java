package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class HKR_SubstringDiff {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int k = in.nextInt();
        char[] a = in.next().toCharArray();
        char[] b = in.next().toCharArray();
        int n = a.length;

        int[][] diff_array = new int[n][n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                diff_array[i][j] = (a[i] != b[j]) ? 1 : 0;
        }
        int front_pointer, back_ptr1, back_ptr2, front_sum1, front_sum2, curr_max = -1;
        int back_sum1, back_sum2;
        for (int i = 0; i < n; i++) {
            front_sum1 = front_sum2 = back_sum1 = back_sum2 = 0;
            back_ptr1 = back_ptr2 = -1;
            for (front_pointer = 0; front_pointer + i < n; front_pointer++) {
                front_sum1 += diff_array[front_pointer][i + front_pointer];
                front_sum2 += diff_array[i + front_pointer][front_pointer];
                while (front_sum1 - back_sum1 > k) {
                    back_ptr1++;
                    back_sum1 += diff_array[back_ptr1][i + back_ptr1];
                }
                while (front_sum2 - back_sum2 > k) {
                    back_ptr2++;
                    back_sum2 += diff_array[i + back_ptr2][back_ptr2];
                }

                if (front_pointer - back_ptr1 > curr_max)
                    curr_max = front_pointer - back_ptr1;
                if (front_pointer - back_ptr2 > curr_max)
                    curr_max = front_pointer - back_ptr2;
            }
        }

        out.println(curr_max);
    }

}
