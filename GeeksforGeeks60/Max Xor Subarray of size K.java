class Solution {
    public int maxSubarrayXOR(int[] arr, int k) {
        int xor=0;
        for (int i=0;i<k;i++) 
              xor^= arr[i];
       
        int maxXor=xor;
        for (int i=k; i<arr.length;i++)
        {
            xor=xor^arr[i-k]^arr[i];
            if (xor > maxXor) 
                maxXor=xor;
        }
        return maxXor;
    }
}
