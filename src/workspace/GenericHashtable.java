package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenericHashtable {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();

        Hashtable<Integer, Integer> table = new Hashtable<Integer, Integer>();
        for(int i = 0; i < n; ++i) {
            int key = in.nextInt(), value = in.nextInt();
            table.put(key, value);
        }

        int []check = {10, 0, 1, 100};
        for(int c : check)
            out.printf("Contains %d ? %b\n", c, table.contains(c));

        out.println("\nTable structure: ");
        out.print(table);
    }

    class Hashtable<K,V> {
        class Entry<TKey,TValue> {
            TKey Key;
            TValue Value;
            public Entry(TKey key, TValue value) {
                this.Key = key;
                this.Value = value;
            }
        }

        int capacity = 10;
        List<ArrayList<Entry<K,V>>> array;

        public Hashtable() {
            this.array = new ArrayList<>(capacity);
            for(int i = 0; i < capacity; ++i)
                array.add(null);
        }

        public V put(K key, V value) {
            Entry<K,V> newEntry = new Entry<>(key, value);
            int hash = key.hashCode() % capacity;
            ArrayList<Entry<K,V>> list = array.get(hash);

            if(list == null) {
                list = new ArrayList<Entry<K, V>>();
                array.set(hash, list);
            }
            else {
                // duplicate key
                for(Entry<K,V> e : list) {
                    if (e.Key.equals(key)) {
                        V oldValue = e.Value;
                        e.Value = value;
                        return oldValue;
                    }
                }
            }
            list.add(newEntry);
            return null;
        }

        public V get(K key) {
            int hash = key.hashCode() % capacity;
            List<Entry<K,V>> list = array.get(hash);
            for(Entry<K,V> e : list) {
                if(e.Key.equals(key))
                    return e.Value;
            }
            return null; // not found
        }

        public boolean contains(K key) {
            return get(key) != null;
        }

        @Override
        public String toString() {
            String rs = "";
            for(int i = 0; i < capacity; ++i) {
                List<Entry<K,V>> list = array.get(i);
                if(list != null) {
                    rs += i + ": ";
                    for(Entry<K,V> e : list)
                        rs += e.Value + " ";
                    rs += "\n";
                }
            }
            return rs;
        }
    }
}
