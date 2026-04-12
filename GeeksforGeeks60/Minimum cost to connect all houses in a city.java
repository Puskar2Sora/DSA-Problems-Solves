class Solution {
    public int minCost(int[][] houses) {
        int n = houses.length;
        if (n <= 1) return 0;
        int[] minDist = new int[n];
        for (int i = 0; i < n; i++) minDist[i] = Integer.MAX_VALUE;
        boolean[] inMST = new boolean[n];
        minDist[0] = 0;
        int totalCost = 0;
        for (int i = 0; i < n; i++) {
            int u = -1;
          for (int j = 0; j < n; j++) {
                if (!inMST[j] && (u == -1 || minDist[j] < minDist[u])) u = j;
            }
            inMST[u] = true;
            totalCost += minDist[u];
          for (int v = 0; v < n; v++) {
                if (!inMST[v]) {
                    int dist = Math.abs(houses[u][0] - houses[v][0]) + 
                               Math.abs(houses[u][1] - houses[v][1]);
                    if (dist < minDist[v])  minDist[v] = dist;
                }
            }
        }

        return totalCost;
    }
}
