package workspace;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class Heap {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();

        BinaryHeap heap = new BinaryHeap(n);
        for(int i = 0; i < n; ++i) {
            int x = in.nextInt();
            heap.insert(x);
        }

        out.println(heap.toString());
        heap.removeMin();
        out.println(heap.toString());
    }

    public class BinaryHeap {
        private int[] arr;
        private int current_size = 1;
        public int length;

        public BinaryHeap(int size) {
            arr = new int[size + 1];
            Arrays.fill(arr, Integer.MAX_VALUE);
        }

        public void insert(int v) {
            arr[current_size] = v;
            int pos = current_size;
            // compare with parent (aka UP HEAP)
            while(v < arr[pos / 2] && pos > 1) {
                arr[pos] = arr[pos / 2];
                arr[pos / 2] = v;
                pos = pos / 2;
            }
            current_size += 1;
        }

        // remove root
        public void removeMin() {
            arr[1] = arr[current_size - 1];
            current_size -= 1;
            arr[current_size] = Integer.MAX_VALUE; // remove this element

            int pos = 1;
            // compare with child (aka DOWN HEAP)
            while(pos * 2 < current_size) {
                int child_pos = pos * 2;
                if(pos * 2 + 1 < current_size)
                    child_pos = arr[child_pos] <=  arr[pos * 2 + 1]? child_pos : pos * 2 + 1;
                if(arr[pos] > arr[child_pos]) {
                    int tmp = arr[pos];
                    arr[pos] = arr[child_pos];
                    arr[child_pos] = tmp;
                }
                else
                    break;
                pos = child_pos;
            }
        }

        @Override
        public String toString() {
            String s = "";
            for(int i = 1; i < current_size; ++i)
                s += arr[i] + " ";
            return s;
        }
    }
}
