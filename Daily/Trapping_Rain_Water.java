import java.util.*;
// Time complextiy  O(n^2)
/* 
import java.util.*;
class Solution {
    public int maxWater(int arr[]) {
        // code here
    int n=arr.length,s=0;
    for(int i=0;i<n;i++)
    {
      int h=arr[i],ml=arr[i],mr=arr[i];
       
       if(i==0)
         ml=arr[i];
       else{
         for(int j=i;j>=0;j--)
         { 
             if(ml<arr[j])
                ml=arr[j];
         }
       }
       if(i==n-1)
        mr=arr[i];
       else
       {
          for(int j=i;j<n;j++)
         { 
             if(mr<arr[j])
                mr=arr[j];
         } 
       }
       int wl=Math.min(ml,mr);
       int wt=wl-h;
       if(wt>0)
         s=s+wt;
    }
    return s;
  }
}*/
// Time Comlexity O(n)
class Solution {
    public int maxWater(int[] arr) {

        int n = arr.length;
        int left = 0, right = n - 1;
        int leftMax = 0, rightMax = 0;
        int water = 0;

        while (left <= right) {

            if (arr[left] <= arr[right]) {

                if (arr[left] >= leftMax)
                    leftMax = arr[left];
                else
                    water += leftMax - arr[left];

                left++;

            } else {

                if (arr[right] >= rightMax)
                    rightMax = arr[right];
                else
                    water += rightMax - arr[right];

                right--;
            }
        }
        return water;
    }
}

