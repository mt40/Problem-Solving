package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class DigitSumFrom1ToN {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();

        /**
         * Solution idea: http://math.stackexchange.com/a/817080
         * Phan tich so N thanh dang 10q + r (q >= 0, 0 <= r <= 9)
         * Nhu vay ta se chia tong can tim thanh 4 nhom:
         * 1- tong cac so hang don vi cua cac so tu 0 -> 10q - 1
         * 2- tong cac so o cac hang con lai tu 0 -> 10q - 1
         * 3- tong cac so hang don vi tu 10q -> 10q + r (hay chinh la tong tu 1 -> r)
         * 4- tong cac so o cac hang con lai tu 10q -> 10q + r
         */
        out.println(cal(n));
    }

    int cal(int num) {
        if(num <= 0)
            return 0;
        int q = num / 10;
        int r = num % 10;

        return 45 * q + 10 * cal(q - 1) + r * (r + 1) / 2 + sum_of_digits(q) * (r + 1);
    }

    int sum_of_digits(int num) {
        int sum = 0;
        while(num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
