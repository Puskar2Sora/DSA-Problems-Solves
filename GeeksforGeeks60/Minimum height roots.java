import java.util.*;
class Solution {
    public ArrayList<Integer> minHeightRoot(int V, int[][] edges) {
        ArrayList<Integer> res = new ArrayList<>();
        if (V == 1) {
            res.add(0);
            return res;
        }
    List<Set<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new HashSet<>());
        int[] degree = new int[V];
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
            degree[edge[0]]++;
            degree[edge[1]]++;
        }
        Queue<Integer> leaves = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (degree[i] == 1) {
                leaves.offer(i);
            }
        }
        int remainingNodes = V;
        while (remainingNodes > 2) {
            int leafCount = leaves.size();
            remainingNodes -= leafCount;
            for (int i = 0; i < leafCount; i++) {
                int leaf = leaves.poll();
                for (int neighbor : adj.get(leaf)) {
                    degree[neighbor]--;
                    if (degree[neighbor] == 1) {
                        leaves.offer(neighbor);
                    }
                }
            }
        }
        res.addAll(leaves);
        Collections.sort(res); 
        return res;
    }
}