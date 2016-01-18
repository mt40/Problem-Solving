package workspace;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.PrintWriter;

public class CF_278B {
    int[] readArr(int n,Scanner in){int []a=new int[n]; for(int i=0; i<n; ++i) a[i]=in.nextInt();return a;}
    class ShortScanner{Scanner in;ShortScanner(Scanner in){this.in=in;}int i(){return in.nextInt();}long l(){return in.nextLong();}double d(){return in.nextDouble();}String s(){return in.next();}}

    public void solve(int testNumber, Scanner input, PrintWriter out) {
        ShortScanner in = new ShortScanner(input);
        int n = in.i();
        List<String> list = new ArrayList<String>();
        for(int i = 0; i < n; ++i) list.add(in.s());

        for(int i = 1; i <= 30; ++i) {
            String ans = cal("", list, 0, i);
            if(ans != null) {
                out.println(ans);
                return;
            }
        }
    }

    String cal(String s, List<String> list, int l, int len) {
        if(l == len) return null;
        for(int i = 0; i < 26; ++i) {
            String x = s + (char)('a' + i);
            boolean ok = true;
            for(String ss : list) {
                if(ss.contains(x)) {
                    ok = false;
                    break;
                }
            }
            if(ok) {
                return x;
            }
        }
        for(int i = 0; i < 26; ++i) {
            String rs = cal(s + (char)('a' + i), list, l + 1, len);
            if(rs != null) return rs;
        }
        return null;
    }
}
