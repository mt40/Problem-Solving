import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.PrintStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author mthai
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		LCA_in_BinaryTree solver = new LCA_in_BinaryTree();
		solver.solve(1, in, out);
		out.close();
	}
}

class LCA_in_BinaryTree {
    Node root;
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int []a = new int[n];
        for(int i = 0; i < n; ++i) a[i] = in.nextInt();

        for(int i = 0; i < n; ++i)
            insert(a[i]);
        
        int q = in.nextInt();
        for(int i = 0; i < q; ++i) {
            int x = in.nextInt(), y = in.nextInt();
            Node lca = LCA(root, x, y);
            out.println(lca.val);
        }
    }

    void insert(int val) {
        if(root == null)
            root = new Node(val);
        else
            root.insert(val);
    }

    Node LCA(Node cur, int x, int y) {
        if(cur == null) return null;

        // Found x or y
        // Or maybe this is the answer!
        if(cur.val == x || cur.val == y)
            return cur;

        // Recursively find x and y in left and right sub-tree
        Node left = LCA(cur.left, x, y);
        Node right = LCA(cur.right, x, y);

        // x and y found on left & right -> this is the answer
        if(left != null && right != null)
            return cur;

        // if no x & y in the left sub-tree, answer is in the right sub-tree
        return left == null ? right : left;
    }

    class Node {
        int val;
        Node left, right;

        public Node(int val) {
            this.val = val;
        }

        public void insert(int v) {
            if(v < val) {
                if(left == null)
                    left = new Node(v);
                else
                    left.insert(v);
            }
            else {
                if(right == null)
                    right = new Node(v);
                else
                    right.insert(v);
            }
        }
    }
}

class InputReader {
    public BufferedReader reader;
    public StringTokenizer tokenizer;

    public InputReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream));
        tokenizer = null;
    }

    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

}

