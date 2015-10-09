package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class BinaryAddition {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int a = in.nextInt(), b = in.nextInt();
        String bin_a = Integer.toBinaryString(a);
        String bin_b = Integer.toBinaryString(b);
        bin_a = new StringBuilder(bin_a).reverse().toString();
        bin_b = new StringBuilder(bin_b).reverse().toString();

        String sum = Integer.toBinaryString(a + b);
        String bin_sum = binAdd(bin_a.toCharArray(), bin_b.toCharArray());

        out.printf("Normal addition: %s\n", String.valueOf(sum));
        out.printf("Bin addition: %s\n", String.valueOf(bin_sum));
    }

    String binAdd(char []a, char[] b) {
        int n = Math.max(a.length, b.length);
        char []sum = new char[n + 1];

        int carry = 0;
        for(int i = 0; i < n + 1; ++i) {
            char x = (i < a.length) ? a[i] : '0';
            char y = (i < b.length) ? b[i] : '0';
            if(x == '0' && y == '0') {
                sum[i] = (char)(carry + '0');
                carry = 0;
            }
            else if(x == '1' && y == '1') {
                if(carry == 1) {
                    sum[i] = '1';
                }
                else {
                    sum[i] = '0';
                    carry = 1;
                }
            }
            else {
                sum[i] = (carry == 1)? '0' : '1';
            }
        }

        return new StringBuilder(String.valueOf(sum)).reverse().toString();
    }
}
