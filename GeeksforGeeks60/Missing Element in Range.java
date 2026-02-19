import java.util.*;
class Solution {
    public ArrayList<Integer> missingRange(int[] arr, int low, int high) {
        // code here        
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> a = new ArrayList<>();
        
        for(int i:arr)
        {
            if(i>=low && i<=high)
              set.add(i);
        }
        
        for(int i=low; i<=high;i++)
        {
            if(!set.contains(i))
               a.add(i);
        }
        return a;
    }
}