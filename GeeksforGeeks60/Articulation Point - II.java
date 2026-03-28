import java.util.*;

class Solution {
    private int timer = 0;

    public ArrayList<Integer> articulationPoints(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        int[] tin = new int[V];
        int[] low = new int[V];
        boolean[] vis = new boolean[V];
        boolean[] isArticulation = new boolean[V]; 
        for (int i = 0; i < V; i++) {
            if (!vis[i])  dfs(i, -1, vis, tin, low, isArticulation, adj);
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < V; i++) 
            if (isArticulation[i]) result.add(i);
        if (result.isEmpty()) {
            result.add(-1);
            return result;
        }
        Collections.sort(result);
        return result;
    }
    private void dfs(int u, int p, boolean[] vis, int[] tin, int[] low, 
                     boolean[] isArticulation, ArrayList<ArrayList<Integer>> adj) {
        vis[u] = true;
        tin[u] = low[u] = ++timer;
        int children = 0;

        for (int v : adj.get(u)) {
            if (v == p) continue;  
            if (vis[v]) low[u] = Math.min(low[u], tin[v]);
            else {
                children++;
                dfs(v, u, vis, tin, low, isArticulation, adj);
                low[u] = Math.min(low[u], low[v]);
                if (p != -1 && low[v] >= tin[u])  isArticulation[u] = true;
            }
        }
        if (p == -1 && children > 1)  isArticulation[u] = true;
    }
}
