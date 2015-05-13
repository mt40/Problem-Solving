package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.HashSet;

public class CF_514C {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        HashSet<MyString> set = new HashSet<MyString>();
        int n = in.nextInt();
        int m = in.nextInt();

        for(int i = 0; i < n; ++i) {
            set.add(new MyString(in.next(), n));
        }

        String ans = "NO";
        char []cc = {'a', 'b', 'c'};
        for(int i = 0; i < m; ++i) {
            String s = in.next();
            char []a = s.toCharArray();

            for(int j = 0; j < s.length(); ++j) {
                char old = a[j];
                for(int k = 0; k < 3; ++k) {
                    if(a[j] != cc[k]) {
                        a[j] = cc[k];
                        MyString ms = new MyString(String.valueOf(a), n);
                        if(set.contains(ms)) {
                            ans = "YES";
                            //break
                            k = 3; j = s.length();
                        }
                    }
                }
                if(j < s.length())
                    a[j] = old; // return the original character
            }
            out.println(ans);
            ans = "NO";
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
