package workspace;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.io.PrintWriter;

public class HeapImplementation {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        Heap heap = new Heap(10);
        for(int i = 0; i < n; ++i)
            heap.add(in.nextInt());

        out.println(heap);
        int to_pop = new Random().nextInt(n - 1);
        while(to_pop-- > 0) {
            heap.pop();
            out.println("pop!");
            out.println(heap);
        }
    }

    // Max heap
    class Heap {
        int count, capacity;
        int []data;

        public Heap(int capacity) {
            this.capacity = capacity;
            data = new int[capacity];
        }

        int top() {
            if(count == 0)
                return Integer.MIN_VALUE;
            return data[0];
        }

        int leftChild(int id) {
            return id * 2 + 1;
        }

        int rightChild(int id) {
            return id * 2 + 2;
        }

        int parent(int id) {
            return (id - 1) / 2;
        }

        void swap(int i, int j) {
            int tmp = data[i];
            data[i] = data[j];
            data[j] = tmp;
        }

        public boolean add(int val) {
            if(count == capacity)
                return false;

            data[count] = val;
            int pos = count, parent = parent(pos);
            count++;

            // upheap
            while(pos > 0 && data[parent] < val) {
                swap(parent, pos);
                pos = parent;
                parent = parent(pos);
            }
            return true;
        }

        /**
         * Pop the top element
         */
        public boolean pop() {
            if(count == 0) return false;

            data[0] = data[count - 1];
            count--;
            int pos = 0, left = leftChild(pos), right = rightChild(pos);
            // down-heap
            while(left < count || right < count) {
                int next = (data[left] < data[right]) ? right : left;
                swap(pos, next);
                pos = next;
                left = leftChild(pos);
                right = rightChild(pos);
            }
            return true;
        }

        int find(int val) {
            for(int i = 0; i < count; ++i) {
                if(data[i] == val)
                    return i;
            }
            return -1;
        }

        @Override
        public String toString() {
            String s = "";
            for(int i = 0; i < count; ++i)
                s += data[i] + " ";
            return s;
        }
    }
}
