package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;

/**
 * Customize HashSet with my own hash function
 */
public class HashSet_custom {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        HashSet<MyString> set = new HashSet<MyString>();
        int n = in.nextInt();

        for(int i = 0; i < n; ++i) {
            set.add(new MyString(in.next(), n));
        }

        for (MyString s : set) {
            System.out.println(s.value);
        }
    }

    class MyString {
        public String value;

        private final int coefficient = 11; // choose a prime number
        private int hashIndex;
        private int char_sum;
        private int table_size; // hash table size
        private int hashKey;

        public MyString(String val, int n_strings) {
            this.value = val;
            this.table_size = n_strings;
            compute();
        }

        private void compute() {
            int n = value.length();
            char []a = value.toCharArray();

            for(int i = 0; i < n; ++i)
                char_sum += (int)a[i];

            for(int i = 0; i < n; ++i) {
                hashIndex += a[i] * (int) ((long) Math.pow(coefficient, i) % char_sum);
                hashIndex %= char_sum;
            }

            hashKey = (hashIndex % table_size * n % table_size) % table_size;
        }

        @Override
        public int hashCode() {
            return hashKey;
        }

        @Override
        public boolean equals(Object obj) {
            return value.equals(((MyString)obj).value);
        }
    }
}
