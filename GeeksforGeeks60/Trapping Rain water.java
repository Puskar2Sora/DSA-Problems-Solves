import java.util.*;
class Solution {
    public int maxWater(int arr[]) {
       
        int[] lmax=new int[arr.length];
        int[] rmax=new int[arr.length];
        int w=0;
        
        lmax[0]=arr[0];
        rmax[arr.length-1]=arr[arr.length-1];
        
        for(int i=1;i<arr.length;i++)
           lmax[i]=Math.max(lmax[i-1],arr[i]);
           
        for(int i=arr.length-2; i>=0;i--)
           rmax[i]=Math.max(rmax[i+1],arr[i]);
        
        for(int i=0;i<arr.length;i++)
           w +=(Math.min(rmax[i],lmax[i])-arr[i]);
     return w;   
    }
}
