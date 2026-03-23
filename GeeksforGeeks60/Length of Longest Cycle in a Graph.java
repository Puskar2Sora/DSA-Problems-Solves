import java.util.*;

class Solution {
    public int longestCycle(int V, int[][] edges) {
        int[] adj = new int[V];
        Arrays.fill(adj, -1);
        for (int[] edge : edges) {
            adj[edge[0]] = edge[1];
        }

        int longestCycleLen = -1;
        int[] timeVisited = new int[V]; 
        Arrays.fill(timeVisited, -1);
        boolean[] visited = new boolean[V];
        int currentTime = 1;
        for (int i = 0; i < V; i++) {
            if (visited[i]) continue;

            int startTime = currentTime;
            int curr = i;
            while (curr != -1 && !visited[curr]) {
                visited[curr] = true;
                timeVisited[curr] = currentTime++;
                curr = adj[curr];
            }
      if (curr != -1 && timeVisited[curr] >= startTime) {
                int cycleLen = currentTime - timeVisited[curr];
                longestCycleLen = Math.max(longestCycleLen, cycleLen);
            }
        }

        return longestCycleLen;
    }
}