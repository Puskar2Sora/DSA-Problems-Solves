class Solution {
    public int kBitFlips(int[] arr, int k) {
        int a=0,b=0;
        for(int i=0;i<arr.length;i++)
        {
            if(i>=k && arr[i-k]==2)
              b--;
            if(b%2==arr[i])
            {
                if((i+k)>arr.length)
                 return -1;
            arr[i]=2;
            b++;
            a++;
            }
        }
        return a;
    }
}
