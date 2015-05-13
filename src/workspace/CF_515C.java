package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class CF_515C {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        char[]a = in.next().toCharArray();

        /**
         * ý tưởng: viết các số xuất hiện trong các giai thừa,
         * tách các số đó thành các số nhỏ hơn (vd: 6 -> 3 và 2)
         * (vì càng nhiều số nhỏ -> càng có thể có nhiều giai thừa ->
         * càng có nhiều chữ số cho kết quả -> kết quả càng lớn)
         * đi từ k = 9 -> 1, xem xem có thể có k giai thừa từ các số
         * tách dc ko? Nếu có thì thêm k vào chuổi ans
         */
        int []nums = new int[10];
        for(int i = 0; i < n; ++i) {
            int x = a[i] - '0';
            for(int j = 1; j <= x; ++j) {
                int tmp = j;
                if(tmp == 1)
                    nums[1]++;
                else {
                    for(int k = 2; k <= j; ++k) {
                        while(tmp % k == 0) {
                            nums[k]++;
                            tmp /= k;
                        }
                    }
                }
            }
        }

        String ans = "";
        for(int i = 9; i >= 1; --i) {
            while(nums[i] > 0) {
                for(int j = 1; j <= i; ++j) {
                    if(j == 4)
                        nums[2] -= 2;
                    else if(j == 6) {
                        nums[2]--; nums[3]--;
                    }
                    else if(j == 8)
                        nums[2] -= 4;
                    else if(j == 9)
                        nums[3] -= 3;
                    else
                        nums[j]--;
                }
                ans += i + "";
            }
        }

        //System.out.println(Arrays.toString(nums));
        out.println(ans);
    }
}
