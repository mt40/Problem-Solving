package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_DICT {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        Trie trie = new Trie();
        for(int i = 0; i < n; ++i) {
            char []word = in.c();
            trie.add(trie.root, word, 0);
        }

        int k = in.i();
        for(int i = 0; i < k; ++i) {
            char []prefix = in.c();
            Set<String> rs = trie.query(prefix);

            out.printf("Case #%d:\n", i + 1);
            if(rs.size() == 0)
                out.println("No match.");
            else {
                for (String s : rs)
                    out.println(s);
            }
        }
    }

    class Trie {
        Node root = new Node();

        void add(Node cur, char []word, int i) {
            if(i == word.length) {
                cur.isWord = true;
                return;
            }
            char c = word[i];
            if(cur.get(c) == null)
                cur.set(c, new Node());
            add(cur.get(c), word, i + 1);
        }

        Set<String> query(char []prefix) {
            results = new TreeSet<>();
            Node start = find(root, prefix, 0);

            if(start != null)
                getSuffixes(start, new StringBuilder(String.valueOf(prefix)));
            return results;
        }

        Set<String> results;
        void getSuffixes(Node cur, StringBuilder word) {
            for(int i = 0; i < 26; ++i) {
                Node next = cur.next[i];
                char c = (char)('a' + i);

                if(next == null) continue;

                word.append(c);
                if(next.isWord)
                    results.add(word.toString());
                getSuffixes(next, word);
                word.deleteCharAt(word.length() - 1); // release
            }
        }

        Node find(Node cur, char []prefix, int i) {
            if(i == prefix.length)
                return cur;
            char c = prefix[i];
            Node next = cur.get(c);
            if(next != null)
                return find(next, prefix, i + 1);
            return null;
        }
    }

    class Node {
        Node []next = new Node[26];
        boolean isWord;

        Node get(char c) {
            return next[c - 'a'];
        }

        void set(char c, Node val) {
            next[c - 'a'] = val;
        }
    }
}