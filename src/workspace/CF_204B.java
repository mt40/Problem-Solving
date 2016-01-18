package workspace;



import java.util.*;
import java.io.PrintWriter;

public class CF_204B {
    class ShortScanner{Scanner in;ShortScanner(Scanner in){this.in=in;}int i(){return in.nextInt();}long l(){return in.nextLong();}double d(){return in.nextDouble();}String s(){return in.next();}char[] c(){return in.next().toCharArray();}int[] arr(int n){int []a=new int[n]; for(int i=0; i<n; ++i) a[i]=in.nextInt();return a;}}
    double max(double...v) {double m=Double.NEGATIVE_INFINITY; for (double d:v) if(d>m)m=d; return m;}
    long max(long...v) {long m=Long.MIN_VALUE; for(long i:v)if(i>m)m=i; return m;}
    double min(double...v) {double m=Double.POSITIVE_INFINITY; for (double d:v) if(d<m)m=d; return m;}
    long min(long...v) {long m=Long.MAX_VALUE; for(long i:v)if(i<m)m=i; return m;}
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, Scanner input, PrintWriter out) {
        ShortScanner in = new ShortScanner(input);
        int n = in.i();
        Map<Integer, Integer> dup = new HashMap<>();
        Map<Integer, Integer> map_up = new HashMap<>(), map_down = new HashMap<>();
        List<Integer> colors = new ArrayList<>();
        for(int i = 0; i < n; ++i) {
            int a = in.i(), b = in.i();
            addEntry(map_up, a, 1);
            addEntry(map_up, b, 0);
            addEntry(map_down, b, 1);
            addEntry(map_down, a, 0);
            if(a == b) addEntry(dup, a, 1);
            else {
                addEntry(dup, a, 0);
                addEntry(dup, b, 0);
            }
            colors.add(a); colors.add(b);
        }

        int min = inf;
        boolean ok = false;
        for(int c : colors) {
            int dif = (n + 1) / 2 - map_up.get(c);

            if(dif <= 0) {
                min = 0; ok = true; break;
            }
            int t = dif - map_down.get(c) + dup.get(c);
            if(t <= 0) {
                ok = true;
                min = Math.min(Math.min(dif, map_down.get(c)), min);
            }
        }

        if(!ok) out.println(-1);
        else out.println(min);
    }

    void addEntry(Map<Integer, Integer> map, int key, int val) {
        if(map.containsKey(key))
            map.put(key, map.get(key) + val);
        else
            map.put(key, val);
    }
}
