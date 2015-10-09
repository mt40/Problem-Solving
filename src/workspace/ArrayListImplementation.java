package workspace;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class ArrayListImplementation {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < n; ++i)
            list.add(in.nextInt());

        out.println(list);
        list.remove(0);
        out.println(list);
        list.add(100);
        out.println(list);
        list.add(5);
        out.println(list);
        list.remove(1);
        out.println(list);
    }

    class ArrayList<T> {
        Object []array;
        int length, last = -1;
        double expand_factor = 1.5;

        public ArrayList() {
            array = new Object[2];
        }

        void expand() {
            Object []old = array;
            array = new Object[(int)(old.length * expand_factor)];
            System.arraycopy(old, 0, array, 0, old.length);
        }

        void add(T value) {
            last++;
            if(last == array.length)
                expand();
            array[last] = value;
            length++;
        }

        T get(int index) {
            if(index < 0 || index >= length)
                throw new IndexOutOfBoundsException(String.format("Access at %d while array length is %d", index, length));
            return (T)array[index];
        }

        void remove(T value) {
            for(int i = 0; i < length; ++i) {
                if(array[i].equals(value)) {
                    for(int j = i; j < length - 1; ++j)
                        array[j] = array[j + 1];
                    array[last] = null;
                    last--;
                    length--;
                    break;
                }
            }
        }

        @Override
        public String toString() {
            return Arrays.toString(array);
        }
    }
}
