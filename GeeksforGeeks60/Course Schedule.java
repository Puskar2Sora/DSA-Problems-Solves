import java.util.*;

class Solution {
    // The driver code expects "canFinish", not "isPossible"
    public boolean canFinish(int n, int[][] prerequisites) {
        // 1. Build adjacency list and in-degree array
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        int[] inDegree = new int[n];
        
        // 2. Fill the graph
        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prereq = pre[1];
            adj.get(prereq).add(course);
            inDegree[course]++;
        }
        
        // 3. Queue for BFS (Kahn's Algorithm)
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        
        // 4. Process nodes
        int count = 0;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            count++;
            
            for (int neighbor : adj.get(curr)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }
        
        // 5. If count equals n, all courses can be finished
        return count == n;
    }
}
