package workspace;

import java.util.*;
import java.io.PrintWriter;

public class DFS {
    int V;
    //adjacent list
    int[][] adj;

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        V = in.nextInt();
        adj = new int[V][V];
        for(int i = 0; i < V; ++i)
            for(int j = 0; j < V; ++j)
                adj[i][j] = in.nextInt();

        int []visit = new int[V];
        for(int i = 0; i < V; ++i) {
            if(visit[i] == 0)
                dfs(visit, i);
        }
        System.out.println();
        bfs();
        System.out.println();
        connectedComponent();
        topoSort();
        isBipartite();
        //out.println(isBipartite2(new int[V], new HashMap<Integer, Integer>(), 0));
        find_articulation();
    }

    public void dfs(int[] visit, int v) {
        for (int i = 0; i < adj[v].length; ++i) {
            if (adj[v][i] == 1 && visit[i] == 0) {
                System.out.print(i + " ");
                visit[i] = 1;
                dfs(visit, i);
            }
        }
    }

    public void bfs() {
        int []visit = new int[V];
        Queue<Integer> q = new LinkedList<Integer>();
        for(int j = 0; j < V; ++j) {
            if(visit[j] == 0)
                q.add(j); // enqueue root
            while (q.size() > 0) {
                int v = q.poll(); // dequeue
                visit[v] = 1;
                System.out.print(v + " ");
                for (int i = 0; i < V; ++i)
                    if (adj[v][i] == 1 && visit[i] == 0 && !q.contains(i))
                        q.add(i);
            }
        }
    }

    public void connectedComponent() {
        int []visit = new int[V];
        int id = 1;
        for(int i = 0; i < V; ++i) {
            if(visit[i] == 0) {
                System.out.print("Component " + (id++) + ": ");
                dfs(visit, i);
                System.out.println();
            }
        }
    }

    // topological sort of a Directed Acyclic Graph
    public void topoSort() {
        LinkedList<Integer> topo = new LinkedList<Integer>();
        int []visit = new int[V];
        for(int i = 0; i < V; ++i) {
            if(visit[i] == 0)
                topoDfs(topo, visit, i);
        }

        //reverse the list
        for(int i = topo.size() - 1; i >= 0; --i)
            System.out.print(topo.get(i) + " ");

    }

    public void topoDfs(LinkedList<Integer> topo, int []visit, int v) {
        for(int i = 0; i < adj[v].length; ++i) {
            if(adj[v][i] == 1 && visit[i] == 0) {
                visit[i] = 1;
                topoDfs(topo, visit, i);
            }
        }
        if(!topo.contains(v))
            topo.add(v); // push v iff all subnode below v is visited
    }

    // check if the graph is bipartite (using BFS)
    public boolean isBipartite() {
        // use bfs
        int []visit = new int[V];
        Queue<Integer> q = new LinkedList<Integer>();
        Map<Integer, Integer> color = new HashMap<Integer, Integer>();
        q.add(0);
        color.put(0, 0); // color of root is color 1

        while(q.size() > 0) {
            int v = q.remove();
            visit[v] = 1;
            for(int i = 0; i < V; ++i) {
                if(adj[v][i] == 1 && visit[i] == 0) {
                    if(!color.containsKey(i)) {
                        color.put(i, 1 - color.get(v)); //different color from neightbor
                        q.add(i);
                    }
                    else if(color.get(i) == color.get(v)) {
                        System.out.println("Not bipartite!");
                        return false;
                    }
                }
            }
        }

        System.out.println("Is Bipartite");
        return true;
    }

    // check if the graph is bipartite (using DFS)
    public boolean isBipartite2(int []visit, Map<Integer, Integer>colors, int v) {
        for(int i = 0; i < V; ++i) {
            if(adj[v][i] == 1 && visit[i] == 0) {
                visit[i] = 1;
                if(i == 0)
                    colors.put(i, 0);
                else if(!colors.containsKey(i))
                    colors.put(i, 1 - colors.get(v));
                if(isBipartite2(visit, colors, i) == false)
                    return false;
            }
            else if(adj[v][i] == 1 && v != i && colors.get(i) == colors.get(v))
                return false; // odd circle, cannot use 2 colors
        }
        return true;
    }

    int dfs_root = 0, rootChildren = 0, dfsCounter = 0;
    int []dfs_num = new int[V];
    int []dfs_low = new int[V];
    int []dfs_parent = new int[V];
    int []articulation_vertex = new int[V];

    public void find_articulation() {
        dfs_root = 0; rootChildren = 0; dfsCounter = 0;
        dfs_num = new int[V]; dfs_low = new int[V];
        dfs_parent = new int[V]; articulation_vertex = new int[V];
        Arrays.fill(dfs_num, -1);
        for(int i = 0; i < V; ++i) { // loop through all nodes
            if(dfs_num[i] == -1) {
                dfs_root = i; rootChildren = 0;
                articulation(i);
                articulation_vertex[dfs_root] = (rootChildren > 1)? 1 : 0; // special case
            }
        }
        System.out.println("Articulation points:");
        for(int i = 0; i < articulation_vertex.length; ++i)
            if(articulation_vertex[i] == 1)
                System.out.format("%d ", i);
    }

    // find articulation points using dfs
    public void articulation(int u) {
        dfs_low[u] = dfs_num[u] = dfsCounter++;
        for(int i = 0; i < adj[u].length; ++i) {
            if(adj[u][i] == 1) {
                if (u == dfs_root && i != u) // v is root
                    rootChildren++; // special case: save # root children
                int v = i; // direct child
                if (dfs_num[v] == -1) { // not visited
                    dfs_parent[v] = u; // save u as direct parent

                    articulation(v);

                    if (dfs_low[v] >= dfs_num[u])
                        articulation_vertex[u] = 1; // u is articulation point
                } else if (v != dfs_parent[u])
                    dfs_low[u] = Math.min(dfs_low[u], dfs_num[v]);
            }
        }
    }


}
