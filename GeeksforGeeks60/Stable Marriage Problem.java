import java.util.*;
class Solution {
    public int[] stableMarriage(int[][] men, int[][] women) {
        int n = men.length;
        int[] womanPartner = new int[n];
        int[] manPartner = new int[n];
        Arrays.fill(womanPartner, -1);
        Arrays.fill(manPartner, -1);
        int[][] rank = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int r = 0; r < n; r++) {
                int manId = women[i][r];
                rank[i][manId] = r;
            }
        }
        Queue<Integer> freeMen = new LinkedList<>();
         for (int i = 0; i < n; i++)
            freeMen.add(i);
        int[] nextProposal = new int[n];
        while (!freeMen.isEmpty()) {
            int m = freeMen.poll();
            int w = men[m][nextProposal[m]];
            nextProposal[m]++;
            if (womanPartner[w] == -1) {
                womanPartner[w] = m;
                manPartner[m] = w;
            } else {
                int currentM = womanPartner[w];
                if (rank[w][m] < rank[w][currentM]) {
                    womanPartner[w] = m;
                    manPartner[m] = w;
                    manPartner[currentM] = -1; 
                    freeMen.add(currentM);
                } else
                    freeMen.add(m);
            }
        }
        return manPartner;
    }
}
