class Solution {
    public int solve(int i, int j1, int j2, int n, int m, int[][] grid, Integer[][][] dp) {
        if (j1 < 0 || j1 >= m || j2 < 0 || j2 >= m)
            return (int) -1e9; 
        if (i == n - 1) {
            if (j1 == j2) return grid[i][j1];
            else return grid[i][j1] + grid[i][j2];
        }
        if (dp[i][j1][j2] != null) return dp[i][j1][j2];
        int maxi = (int) -1e9;
        for (int dj1 = -1; dj1 <= 1; dj1++) {
            for (int dj2 = -1; dj2 <= 1; dj2++) {
                int value = 0;
                if (j1 == j2) value = grid[i][j1]; 
                else value = grid[i][j1] + grid[i][j2];
                value += solve(i + 1, j1 + dj1, j2 + dj2, n, m, grid, dp);
                maxi = Math.max(maxi, value);
            }
        }
        return dp[i][j1][j2] = maxi;
    }
    public int maxChocolate(int grid[][]) {
        int n = grid.length;
        int m = grid[0].length;
        Integer[][][] dp = new Integer[n][m][m];
        return solve(0, 0, m - 1, n, m, grid, dp);
    }
}
