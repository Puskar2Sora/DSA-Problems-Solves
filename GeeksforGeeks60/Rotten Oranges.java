import java.util.*;

class Solution {
    public int orangesRot(int[][] mat) {
        if (mat == null || mat.length == 0) return 0;
        int rows = mat.length;
        int cols = mat[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (mat[r][c] == 2) 
                    queue.offer(new int[]{r, c});
                 else if (mat[r][c] == 1) 
                 freshCount++;
            }
        }
        if (freashCount == 0) return 0;
        int minutes = 0;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!queue.isEmpty() && freshCount > 0) {
            int size = queue.size();
            minutes++; 

            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int r = curr[0];
                int c = curr[1];

                for (int[] dir : directions) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];
                    if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && mat[nr][nc] == 1) {
                        mat[nr][nc] = 2; 
                        freshCount--;   
                        queue.offer(new int[]{nr, nc});
                    }
                }
            }
        }
        return freshCount == 0 ? minutes : -1;
    }
}