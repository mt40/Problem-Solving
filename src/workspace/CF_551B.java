package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class CF_551B {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        char[] a = read(in), b = read(in), c = read(in);
        int[] cnt_a = new int[26];
        int[] cnt_b = new int[26];
        int[] cnt_c = new int[26];
        count(a, cnt_a);
        count(b, cnt_b);
        count(c, cnt_c);

        int n = 26;
        int real_b = 0, real_c = 0;
        int times_b = 0, times_c = 0, sum = 0;
        for (int i = 0; ; ++i) {
            boolean valid = true;
            for(int j = 0; j < n; ++j) {
                if(cnt_b[j] > 0 && cnt_a[j] < i)
                    valid = false;
            }
            if(!valid) break;
            times_b = i;
            times_c = 1000000;
            for(int j = 0; j < n; ++j) {
                if(cnt_c[j] > 0) {
                    if(cnt_b[j] > 0)
                        times_c = Math.min((cnt_a[j] - cnt_b[j] * times_b) / cnt_c[j], times_c);
                    else
                        times_c = Math.min(cnt_a[j]/ cnt_c[j], times_c);
                }
            }
            if(times_c == 1000000) times_c = 0;
            if(times_b + times_c > sum) {
                sum = times_b + times_c;
                real_b = times_b;
                real_c = times_c;
            }
        }

        // print
        for(int i = 0; i < real_b; ++i) {
            out.print(new String(b));
        }
        for(int i = 0; i < real_c; ++i) {
            out.print(new String(c));
        }
        for (int i = 0; i < cnt_a.length; ++i) {
            while (cnt_a[i] - cnt_b[i] * real_b - cnt_c[i] * real_c > 0) {
                out.print((char) ('a' + i));
                cnt_a[i]--;
            }
        }
        out.println();
    }

    char[] read(Scanner in) {
        return in.next().toCharArray();
    }

    void count(char[] cc, int[] cnt) {
        for (char ch : cc) {
            cnt[(int) (ch - 'a')]++;
        }
    }
}
