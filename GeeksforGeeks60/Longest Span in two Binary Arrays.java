import java.util.*;
class Solution {
    public int equalSumSpan(int[] a1, int[] a2) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int s = 0;
        int l = 0;
        
        for(int i = 0; i < a1.length; i++) {
            
            s += (a1[i] - a2[i]);
            
            if(s == 0) 
               l = i + 1;
            
            if(map.containsKey(s)) 
                l = Math.max(l, i - map.get(s));
            else
                map.put(s, i);
        }
        
        return l;
        
    }
}