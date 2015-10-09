package workspace;

import java.util.*;
import java.io.PrintWriter;

public class TrieImplementation {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        Trie trie = new Trie();
        for(int i = 0; i < n; ++i)
            trie.add(in.next().toCharArray());

        out.println(trie);
        out.printf("Contains \"dose\": %b\n", trie.find("dose".toCharArray()));
        out.printf("Contains \"dos\": %b\n", trie.find("dos".toCharArray()));
        out.printf("Contains \"cat\": %b\n", trie.find("cat".toCharArray()));
        out.printf("Delete \"cat\"\n", trie.delete("cat".toCharArray()));
        out.printf("Contains \"cat\": %b\n", trie.find("cat".toCharArray()));
        out.println(trie);
    }

    class Trie {
        class Node {
            boolean isWord; // mark the end of a word
            Node []children = new Node[26];

            public boolean isLeaf() {
                for(Node child : children)
                    if(child != null)
                        return false;
                return true;
            }

            @Override
            public String toString() {
                String rs = "";
                for(int i = 0; i < children.length; ++i) {
                    if(children[i] != null) {
                        if(rs.isEmpty())
                            rs += "| ";
                        rs += (char)(i + 'a') + " ";
                    }
                }
                return rs;
            }
        }

        Node root;
        int count;

        public Trie() {
            root = new Node();
        }

        public void add(char []word) {
            this.count++;
            int n = word.length;
            Node cur = root;
            for(int i = 0; i < n; ++i) {
                int c = word[i] - 'a';
                if(cur.children[c] == null) {
                    cur.children[c] = new Node();
                }
                if(i == n - 1)
                    cur.children[c].isWord = true; // mark this is a complete word
                cur = cur.children[c];
            }
        }

        public boolean find(char []word) {
            Node cur = root;
            int n = word.length;
            for(int i = 0; i < n; ++i) {
                int c = word[i] - 'a';
                if(cur.children[c] == null) {
                    return false;
                }
                cur = cur.children[c];
            }
            return cur.isWord;
        }

        public boolean delete(char []word) {
            return delete(root, word, 0);
        }

        boolean delete(Node cur, char []word, int i) {
            if(cur == null) return false;
            if(i == word.length) { // base case
                if(cur.isWord)
                    cur.isWord = false; // mark as deleted
                if(cur.isLeaf())
                    return true; // mark that this node can be deleted
                return false; // mark this node cannot be deleted
            }
            else { // recursive case
                int c = word[i] - 'a';
                if(delete(cur.children[c], word, i + 1)) {
                    cur.children[c] = null;
                    // if cur does not belong to another word and
                    // cur does not have any other child then
                    // mark cur to be deleted
                    return !cur.isWord && cur.isLeaf();
                }
            }
            return false;
        }

        @Override
        public String toString() {
            String rs = "";
            Queue<Node> queue = new LinkedList<Node>();
            queue.add(root);
            while(queue.size() > 0) {
                Node cur = queue.poll();
                rs += cur;
                for(Node x : cur.children) {
                    if(x != null)
                        queue.add(x);
                }
            }

            return rs;
        }
    }
}
