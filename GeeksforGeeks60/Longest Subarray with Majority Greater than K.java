import java.util.*;

class Solution {
    public int longestSubarray(int[] arr, int k) {
        
        int s=0,l=0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > k)
                s+=1;
            else
                s-=1;
          
            if (s> 0)
                l = i+1;
            else
            {
               if (map.containsKey(s - 1))
                    l = Math.max(l, i - map.get(s-1));
            }
            if (!map.containsKey(s))
                map.put(s, i);
        }
        return l;
    }
}