package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class GenericHeap {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int []a = new int[n];
        for(int i = 0; i < n; ++i) a[i] = in.nextInt();

        Heap<Integer> heap = new Heap<>();
        for(int i = 0; i < n; ++i)
            heap.add(a[i]);

        out.println(heap);
        out.println("Heap sort:");
        String s = "";
        while(heap.size > 0) {
            s += " " + heap.poll();
        }
        out.println(s);
    }

    class Heap <E extends Comparable> {
        int size, capacity;
        ArrayList<E> array;

        public Heap() {
            capacity = 5;
            array = new ArrayList<E>();
        }

        void upheap(int pos) {
            if(pos == 0)
                return;
            int parent = (pos - 1) / 2;
            while(pos > 0 && array.get(parent).compareTo(array.get(pos)) >= 0) {
                swap(parent, pos);
                pos = parent;
                parent = (pos - 1)/ 2;
            }
        }

        void downheap() {
            int pos = 0;
            if(pos >= size)
                return;

            int left = pos * 2 + 1;
            int right = pos * 2 + 2;

            while(left < size || right < size) {
                int next = left;
                if(right < size && array.get(right).compareTo(array.get(left)) < 0)
                    next = right;

                swap(next, pos);
                pos = next;
                left = pos * 2 + 1;
                right = pos * 2 + 2;
            }
        }

        public void add(E item) {
            array.add(item);
            upheap(size);
            size++;
            if(size == capacity)
                resize();
        }

        public E poll() {
            if(size == 0)
                return null;
            E item = array.get(0);
            swap(size - 1, 0);
            array.remove(size - 1);
            size--;
            downheap();
            return item;
        }

        void resize() {
            // normally copy the whole array to the new one
            // but since the arraylist do that for us, just
            // update the capacity
            capacity = array.size();
        }

        void swap(int i, int j) {
            E tmp = array.get(i);
            array.set(i, array.get(j));
            array.set(j, tmp);
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for(E e : array) {
                sb.append(" ").append(e.toString());
            }
            return sb.toString();
        }
    }
}
