package workspace;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class CF_490C {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        String s = in.next();
        char []num = s.toCharArray();
        int n = num.length;
        int a = in.nextInt(), b = in.nextInt();

        int []ten = new int[n + 1]; // array of 10^i mod b
        ten[0] = 1;
        for(int i = 1; i <= n; ++i)
            ten[i] = (ten[i - 1] * (10 % b)) % b;

        /**
         * pre_mod[i] = s? d? c?a s? ???c t?o thành khi c?t t? 0->i ?em chia cho a
         * suf_mod[i] = s? d? c?a s? dc t?o thành khi c?t t? i->n-1 ?em chia cho b
         */
        int []pre_mod = new int[n];
        int []suf_mod = new int[n];

        pre_mod[0] = (num[0] - '0') % a;
        for(int i = 1; i < n; ++i) {
            pre_mod[i] = pre_mod[i - 1] * 10 + (int)(num[i] - '0');
            pre_mod[i] %= a;
        }

        suf_mod[n - 1] = (num[n - 1] - '0') % b;
        for(int i = n - 2; i >= 0; --i) {
            suf_mod[i] = ((int)(num[i] - '0')) * ten[n - i - 1] + suf_mod[i + 1];
            suf_mod[i] %= b;
        }

        //System.out.println(Arrays.toString(pre_mod));
        //System.out.println(Arrays.toString(suf_mod));

        String ans = "NO";
        // Find the pos where pre_mod = suf_mod = 0 and the second number has no leading zeros
        for(int i = 0; i < n - 1; ++i) {
            if(pre_mod[i] == 0 && suf_mod[i + 1] == 0 && num[i + 1] != '0') {
                ans = String.format("YES\n%s\n%s", s.substring(0, i + 1), s.substring(i + 1));
                break;
            }
        }

        out.println(ans);
    }
}
