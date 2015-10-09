package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class BIT_Implementation {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt(), m = in.nextInt();
        int []a = new int[n];
        for(int i = 0; i < n; ++i)
            a[i] = in.nextInt();

        // print
        out.print("Original: ");
        for(int i : a)
            out.print(i + " ");

        BIT tree = new BIT(a);

        out.print("\nBIT: ");
        out.println(tree);

        while(m-- > 0) {
            int l = in.nextInt(), r = in.nextInt();
            out.printf("Sum %d -> %d: %d\n", l, r, tree.rangeQuery(l, r));
        }
    }

    class BIT {
        int []array;
        int size;

        public BIT(int []source) {
            this.size = source.length;
            array = new int[size + 1];
            for(int i = 0; i < source.length; ++i) {
                update(i, source[i]);
            }
        }

        public int rangeQuery(int l, int r) {
            if(l == 0)
                return getSum(r);
            return getSum(r) - getSum(l - 1);
        }

        // sum from [0..index]
        int getSum(int index) {
            index += 1;
            int sum = 0;
            while(index > 0) {
                sum += array[index];
                index -= index & (-index); // go to the lower interval
            }
            return sum;
        }

        public void update(int index, int val) {
            index += 1; // index in BIT starts from 1
            // traverse the tree and add 'val' to interval that covers
            // index
            while(index <= size) {
                array[index] += val;
                index += index & (-index); /* we shift the last set bit left 1 position
                in fact, we want to go the the higher node that also covers this interval */
            }
        }

        @Override
        public String toString() {
            String s = "";
            for(int i = 1; i <= size; ++i)
                s += array[i] + " ";
            return s;
        }
    }
}
