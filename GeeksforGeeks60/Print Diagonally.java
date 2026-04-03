import java.util.ArrayList;
class Solution {
    public ArrayList<Integer> diagView(int[][] mat) {
        int n = mat.length; 
        ArrayList<Integer> result = new ArrayList<>();
        for (int s=0; s<=2*n-2;s++) {
            int i = Math.max(0,s-(n-1));
            while (i<n && (s - i)>=0) {
                result.add(mat[i][s - i]);
                i++;
            }
        }
        return result;
    }
}
