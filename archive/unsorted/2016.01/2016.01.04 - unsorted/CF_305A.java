package workspace;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.PrintWriter;

public class CF_305A {
    class ShortScanner{Scanner in;ShortScanner(Scanner in){this.in=in;}int i(){return in.nextInt();}long l(){return in.nextLong();}double d(){return in.nextDouble();}String s(){return in.next();}char[] c(){return in.next().toCharArray();}int[] arr(int n){int []a=new int[n]; for(int i=0; i<n; ++i) a[i]=in.nextInt();return a;}}
    double max(double...v) {double m=Double.NEGATIVE_INFINITY; for (double d:v) if(d>m)m=d; return m;}
    long max(long...v) {long m=Long.MIN_VALUE; for(long i:v)if(i>m)m=i; return m;}
    double min(double...v) {double m=Double.POSITIVE_INFINITY; for (double d:v) if(d<m)m=d; return m;}
    long min(long...v) {long m=Long.MAX_VALUE; for(long i:v)if(i<m)m=i; return m;}
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, Scanner input, PrintWriter out) {
        ShortScanner in = new ShortScanner(input);
        int n = in.i();
        int []a = in.arr(n);

        boolean b1 = false, b2 = false;
        List<Integer> list = new ArrayList<>();
        for(int i : a) {
            if(i == 0 || i == 100) list.add(i);
            else if(i < 10 && !b1) {
                b1 = true;
                list.add(i);
            }
            else if(i % 10 == 0 && !b2) {
                b2 = true;
                list.add(i);
            }
        }

        if(!b1 && !b2) {
            for(int i : a)
                if(i >= 10 && i < 100) {
                    list.add(i);
                    break;
                }
        }

        out.println(list.size());
        for(int i : list) out.print(i + " ");
        out.println();
    }
}
