package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class AdobeHackathon_APerfectArray {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int []a = new int[n];
        for(int i = 0; i < n; ++i) {
            a[i] = in.nextInt();
        }

        PriorityQueue<Integer> odd = new PriorityQueue<>();
        PriorityQueue<Integer> even = new PriorityQueue<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; ++i) {
            if(a[i] % 2 == 0)
                even.add(a[i]);
            else
                odd.add(a[i]);
            map.put(a[i], i);
        }

        int ans = 0;
        if(n % 2 > 0) {
            out.println(ans);
            return;
        }

        for(int i = 0; i < n; ++i) {
            if((i + 1) % 2 == 0) {
                if(a[i] != even.peek()) {
                    int pos = map.get(even.peek());
                    map.put(a[i], pos);
                    swap(a, i, pos);
                    ans++;
                }
                even.poll();
            }
            else {
                if(a[i] != odd.peek()) {
                    int pos = map.get(odd.peek());
                    map.put(a[i], pos);
                    swap(a, i, pos);
                    ans++;
                }
                odd.poll();
            }
        }

        out.println(ans);
    }

    void swap(int []a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    class Pair implements Comparable<Pair> {
        int a, b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Pair o) {
            return Integer.compare(a, o.a);
        }
    }
}
