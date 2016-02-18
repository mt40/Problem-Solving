package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class CF_608B {
    class ShortScanner{Scanner in;ShortScanner(Scanner in){this.in=in;}int i(){return in.nextInt();}long l(){return in.nextLong();}double d(){return in.nextDouble();}String s(){return in.next();}int[] readArr(int n){int []a=new int[n]; for(int i=0; i<n; ++i) a[i]=in.nextInt();return a;}}

    public void solve(int testNumber, Scanner input, PrintWriter out) {
        ShortScanner in = new ShortScanner(input);
        char []a = in.s().toCharArray(), b = in.s().toCharArray();
        int n = a.length, m = b.length;
        int []zero = new int[m], one = new int[m];
        for(int i = 0; i < m; ++i) {
            zero[i] = (b[i] == '0') ? 1 : 0;
            zero[i] += (i > 0) ? zero[i - 1] : 0;
            one[i] = (b[i] == '1') ? 1 : 0;
            one[i] += (i > 0) ? one[i - 1] : 0;
        }

        long ans = 0;
        for(int i = 0; i < n; ++i) {
            int left = i - 1, right = i + m - n;
            if(a[i] == '0') {
                ans += one[right];
                ans -= (i > 0) ? one[left] : 0;
            }
            if(a[i] == '1') {
                ans += zero[right];
                ans -= (i > 0) ? zero[left] : 0;
            }
        }

        out.println(ans);
    }
}
