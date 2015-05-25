package workspace;

import com.sun.deploy.util.ArrayUtil;

import java.util.*;
import java.io.PrintWriter;

public class QuickSelect {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int q = in.nextInt(); // queries
        int[] a = new int[n];
        for (int i = 0; i < n; ++i)
            a[i] = in.nextInt();

        for (int i = 0; i < q; ++i) {
            int query = in.nextInt();
            int ans = select(a, query);
            out.println(ans);
        }
    }

    /**
     * Quick select algorithm
     * Select the k-th smallest element
     * Avarage: O(n), Worst: O(n^2)
     */
    int slowSelect(int []a, int k) {
        int n = a.length;
        if(n <= 5) {
            Arrays.sort(a);
            return a[k - 1];
        }

        // Choose a random element as Median
        int M = (new Random()).nextInt(n + 1);

        // Partition into 3 lists [< M], [= M], [> M]
        List<Integer> l1 = new ArrayList<Integer>();
        List<Integer> l2 = new ArrayList<Integer>();
        List<Integer> l3 = new ArrayList<Integer>();
        for(int i = 0; i < n; ++i) {
            if(a[i] < M)
                l1.add(a[i]);
            else if(a[i] == M)
                l2.add(a[i]);
            else
                l3.add(a[i]);
        }


        if(k <= l1.size()) // answer is in list 1
            return slowSelect(toArray(l1), k);
        else if(k > l1.size() + l2.size()) // k too big, answer is in list 3
            return slowSelect(toArray(l3), k - l1.size() - l2.size());
        return M; // all elements in list 2 are equal, so just return M
    }

    /**
     * Quick select with Median of medians
     * Select the k-th smallest element
     * Complexity: O(n)
     */
    int select(int []a, int k) {
        int n = a.length;
        if(n <= 5) {
            Arrays.sort(a);
            if(k == 0)
                return a[k];
            return a[k - 1];
        }

        int subsets = (int)(n / 5.0 + 0.5);
        int []medians = new int[subsets];
        for(int i = 0; i < subsets; ++i) {
            int left = 5 * i, right = (left + 4) > n ? n : left + 4;
            medians[i] = select(Arrays.copyOfRange(a, left, right), 3);
        }

        int M = select(medians, subsets / 2);

        List<Integer> l1 = new ArrayList<Integer>();
        List<Integer> l2 = new ArrayList<Integer>();
        List<Integer> l3 = new ArrayList<Integer>();
        for(int i = 0; i < n; ++i) {
            if(a[i] < M)
                l1.add(a[i]);
            else if(a[i] == M)
                l2.add(a[i]);
            else
                l3.add(a[i]);
        }

        if(k <= l1.size())
            return select(toArray(l1), k);
        else if(k > l1.size() + l2.size())
            return select(toArray(l3), k - l1.size() - l2.size());
        return M;
    }

    int[] toArray(List<Integer> l) {
        int []rs = new int[l.size()];
        for(int i = 0; i < l.size(); ++i)
            rs[i] = l.get(i);
        return rs;
    }
}
