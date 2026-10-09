import java.util.*;
class Solution {
    public int maxOperations(int[] nums, int k) {
      Map<Integer,Integer> mp=new HashMap<>();
      int c=0;
      for(int i=0;i<nums.length;i++)
      {
        int r=k-nums[i];
        if(mp.containsKey(r))
        {
            c++;
            if(mp.get(r)==1) mp.remove(r);
            else mp.put(r,mp.get(r)-1);
        }
        else mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
      }
      return c;
    }
}