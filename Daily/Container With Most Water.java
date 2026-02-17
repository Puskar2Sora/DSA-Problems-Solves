import java.util.*;
class Solution {
    public int maxWater(int arr[]) {
        // Code Here
        int l=0,r=arr.length-1,m=0;
        while(l<r)
        {
            int h=Math.min(arr[l],arr[r]);
            int w=r-l;
            m=Math.max(h*w,m);
            
            if(arr[l]<arr[r]) l++;
            else r--;
        }
    return m;
    }
}