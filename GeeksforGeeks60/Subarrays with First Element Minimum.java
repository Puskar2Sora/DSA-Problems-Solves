import java.util.*;
class Solution {
    public int countSubarrays(int[] arr) {
        
        int[] mp= new int[arr.length];
        Stack <Integer> st=new Stack<>();
        
        for(int i=arr.length-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i])
                st.pop();
        mp[i]=st.isEmpty()? arr.length : st.peek();
        st.push(i);
        }
        int c=0;
        for(int i=0;i<arr.length;i++)
           c+=mp[i]-i;
        return c;
    } 
}
