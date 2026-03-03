import java.util.*;
class Solution {
    public int totalElements(int[] arr) {
        if(arr.length<=2) return arr.length;
        int l=0,max=0;
        HashMap<Integer, Integer> mp=new HashMap<>();
        
        for(int i=0;i<arr.length;i++)
        {
            mp.put(arr[i],mp.getOrDefault(arr[i], 0)+1);
            while(mp.size()>2)
            {
                mp.put(arr[l],mp.get(arr[l])-1);
                if(mp.get(arr[l])==0)   mp.remove(arr[l]);
                l++;
            }
            max= Math.max(max,i-l+1);
        }
        return max;
    }
}