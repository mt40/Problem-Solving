package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class Trie {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        String []words = new String[n];

        for(int i = 0; i < n; ++i)
            words[i] = in.next();

        SuffixTrie trie = new SuffixTrie();

        for(int i = 0; i < n; ++i)
            trie.addWord(trie.root, words[i]);

        out.println(trie.countWord(trie.root, words[3]));
    }

    public int toIdx(char c) {
        return (int)c - (int)'a';
    }

    public String cutLeftMost(String s) {
        return s.length() > 1 ? s.substring(1) : "";
    }

    class SuffixTrie {
        public Node root; // contains char '' (blank)

        public SuffixTrie() {
            root = new Node();
        }

        public void addWord(Node v, String word) {
            if(word.length() == 0)
                v.words += 1; // add complete
            else {
                char k = word.charAt(0);
                int idx = toIdx(k); // index of k in the alphabet
                if(v.edges[idx] == null)
                    v.edges[idx] = new Node();
                addWord(v.edges[idx], cutLeftMost(word));
            }
        }

        public int countPrefix(Node v, String prefix) {
            if(prefix.length() == 0)
                return v.prefixes; // finish
            char k = prefix.charAt(0);
            int idx = toIdx(k);
            if(v.edges[idx] == null)
                return 0; // not exist
            return countPrefix(v.edges[idx], cutLeftMost(prefix));
        }

        public int countWord(Node v, String word) {
            if(word.length() == 0)
                return v.words; // finish
            char k = word.charAt(0);
            int idx = toIdx(k);
            if(v.edges[idx] == null)
                return 0;
            return countWord(v.edges[idx], cutLeftMost(word));
        }
    }

    class Node {
        int words; int prefixes;
        Node []edges;

        public Node() {
            edges = new Node[26]; // # of English alphabets
            for(int i = 0; i < edges.length; ++i)
                edges[i] = null;
        }
    }
}
