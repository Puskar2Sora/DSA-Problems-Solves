import java.util.*;

class Solution {
    public long subarrayXor(int arr[], int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int prefixXor = 0;
        long count = 0;
        
        for(int num : arr) {
            prefixXor ^= num;
            
            if(prefixXor == k)
                count++;
            int needed = prefixXor ^ k;
            
            if(map.containsKey(needed))
                count += map.get(needed);
                
            map.put(prefixXor, map.getOrDefault(prefixXor, 0) + 1);
        }
        return count;
    }
}