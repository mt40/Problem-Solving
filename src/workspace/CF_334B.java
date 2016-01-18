package workspace;

import java.util.*;
import java.io.PrintWriter;

public class CF_334B {
    class ShortScanner{Scanner in;ShortScanner(Scanner in){this.in=in;}int i(){return in.nextInt();}long l(){return in.nextLong();}double d(){return in.nextDouble();}String s(){return in.next();}int[] readArr(int n){int []a=new int[n]; for(int i=0; i<n; ++i) a[i]=in.nextInt();return a;}}

    public void solve(int testNumber, Scanner input, PrintWriter out) {
        ShortScanner in = new ShortScanner(input);
        int n = 8;
        List<Pair> p = new ArrayList<>();
        for(int i = 0; i < n; ++i) p.add(new Pair(in.i(), in.i()));

        List<Integer> list_x = new ArrayList<>(), list_y = new ArrayList<>();
        for(Pair pp : p) {
            if(!list_x.contains(pp.x))
                list_x.add(pp.x);
            if(!list_y.contains(pp.y))
                list_y.add(pp.y);
        }
        Collections.sort(list_x);
        Collections.sort(list_y);
        if(list_x.size() != 3 || list_y.size() != 3 || p.contains(new Pair(list_x.get(1), list_y.get(1))))
            out.println("ugly");
        else
            out.println("respectable");
    }

    class Pair implements Comparable<Pair> {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pair o) {
            int a = Integer.compare(x, o.x);
            return (a == 0) ? Integer.compare(y, o.y) : a;
        }

        @Override
        public boolean equals(Object o) {
            Pair pair = (Pair)o;
            return x == pair.x && y == pair.y;

        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }
}
