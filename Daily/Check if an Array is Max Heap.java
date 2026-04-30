class Solution {
    public boolean isMaxHeap(int[] arr) {
        // code here
        int n=arr.length;
        for(int i=0; i<=(n-2)/2;i++)
        {
            int l=2*i+1;
            if(l<n && arr[l]>arr[i]) return false;
            int r=2*i+2;
            if(r<n && arr[r]>arr[i]) return false;
        }
        return true;
    }
}
