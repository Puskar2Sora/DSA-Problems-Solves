import java.util.*;

class Solution {
    public static int overlapInt(int[][] arr) {
        // code here
        int n=arr.length;
        int[] suru= new int[n], ses = new int[n];
        
        for(int i=0 ; i<n ; i++)
        {
            suru[i]=arr[i][0];
            ses[i]=arr[i][1];
        }
        
        Arrays.sort(suru);
        Arrays.sort(ses);
        
        int k=0,m=0, t=0,max=0;
        while(k<n && m<n)
        {
            if(suru[k]<=ses[m])
            {
                t++;
                max= Math.max(max,t);
                k++;
            }
            else{
                t--;
                m++;
            }
        }
        return max;
    }
}
