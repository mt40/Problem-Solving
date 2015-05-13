package workspace;

import helperClasses.InputReader;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CF_527B {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        char[] a = in.next().toCharArray();
        char[] b = in.next().toCharArray();
        int dist = 0, pos1 = -1, pos2 = -1;
        List<Integer> dif = new ArrayList<Integer>();

        // Find Hamming Distance
        for (int i = 0; i < n; ++i) {
            if(a[i] != b[i]) {
                dist++;
                dif.add(i);
            }
        }
        if(dist == 0) n = 0; // don't do anything

        boolean done = false;
        /**
         * case 1: đi tìm cặp mà swap sẽ giảm Hamming Dist đi 2
         */
        for (int i = 0; i < n; ++i) {
            if (a[i] == b[i]) continue;
            int start = Collections.binarySearch(dif, i);
            for (int k = start + 1; k < dif.size(); ++k) {
                int j = dif.get(k);
                if (a[i] == b[j] && b[i] == a[j]) {
                    dist -= 2;
                    pos1 = i + 1;
                    pos2 = j + 1;
                    done = true;
                    k = n; i = n; // break
                }
            }
        }
        /**
         * Case 2: tìm cap mà swap sẽ chỉ giảm Hamming Dist đi 1
         */
        if (!done) {
            for (int i = 0; i < n; ++i) {
                if (a[i] == b[i]) continue;
                int start = Collections.binarySearch(dif, i);
                for (int k = start + 1; k < dif.size(); ++k) {
                    int j = dif.get(k);
                    if (a[j] != b[j]) {
                        if (b[i] == a[j] || (a[i] == b[j])) {
                            dist -= 1;
                            pos1 = i + 1;
                            pos2 = j + 1;
                            k = n; i = n;
                        }
                    }
                }
            }
        }

        out.printf("%d\n%d %d\n", dist, pos1, pos2);
    }
}
