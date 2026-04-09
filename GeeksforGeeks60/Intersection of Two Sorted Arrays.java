import java.util.ArrayList;

class Solution {
    public static ArrayList<Integer> intersection(int[] a, int[] b) {
        ArrayList<Integer> p = new ArrayList<>();
        int i=0, j=0, n=a.length, m=b.length;
        while (i < n && j < m) {
            if (a[i] < b[j]) i++;
            else if (b[j] < a[i]) j++;
            else {
                if (p.isEmpty() || p.get(p.size() - 1) != a[i]) 
                p.add(a[i]);
            i++;
            j++;
            }
        }
        return p;
    }
}
