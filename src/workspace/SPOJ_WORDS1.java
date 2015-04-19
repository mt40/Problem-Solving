package workspace;

import helperClasses.InputReader;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class SPOJ_WORDS1 {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int[][] adj_matrix = new int[26][26]; // 26 letters in alphabet
        int n = in.nextInt();

        for (int i = 0; i < n; ++i) {
            char[] a = in.next().toCharArray();
            int start = a[0] - 'a';
            int end = a[a.length - 1] - 'a';
            // connect this edge, but not 2 same vertices
            if (start != end)
                adj_matrix[start][end] = 1;
        }

        // calculate degree of each vertex
        int[] out_edge = new int[26]; // out-going edge
        int[] in_edge = new int[26]; // in-coming edge
        for (int i = 0; i < 26; ++i) {
            for (int j = 0; j < 26; ++j) {
                if (adj_matrix[i][j] == 1) {
                    out_edge[i]++;
                    in_edge[j]++;
                }
            }
        }

        // Euler Trail condition for directed graph
        // https://www.wikiwand.com/en/Eulerian_path
        int valid_edge = 0;
        List<Integer> edges = new ArrayList<Integer>();
        for (int i = 0; i < 26; ++i) {
            if (in_edge[i] - out_edge[i] == 1) {
                valid_edge++;
                edges.add(i);
            }
            if (out_edge[i] - in_edge[i] == 1) {
                valid_edge++;
                edges.add(i);
            }
            if (Math.abs(in_edge[i] - out_edge[i]) > 1)
                valid_edge = 9999; // which means there is no solution
        }

        // check again using DFS
        boolean ans = check(adj_matrix, edges, valid_edge, out_edge, in_edge);

        if (ans)
            out.println("Ordering is possible.");
        else
            out.println("The door cannot be opened.");
    }

    boolean check(int[][] adj_matrix, List<Integer> edges, int valid_edge, int[] out_edge, int[] in_edge) {
        if (valid_edge == 2 || valid_edge == 0) {
            int start = -1;
            if (valid_edge == 2) {
                start = edges.get(0);
                if(out_edge[start] - in_edge[start] < 0)
                    start = edges.get(1);
            }
            else {
                for (int i = 0; i < 26; ++i)
                    if (out_edge[i] > 0) {
                        start = i;
                        break;
                    }
            }

            dfs(adj_matrix, start);
            // Now all edges must be cleared(visited) after dfs
            for (int i = 0; i < 26; ++i) {
                for (int j = 0; j < 26; ++j)
                    if (adj_matrix[i][j] == 1)
                        return false;
            }
        }
        else
            return false;
        return true;
    }

    void dfs(int[][] adj, int start) {
        for (int j = 0; j < 26; ++j) {
            if (adj[start][j] == 1) {
                adj[start][j] = 0; // clear this edge
                dfs(adj, j);
            }
        }
    }
}
