class Solution {
    public int visibleBuildings(int arr[]) {
        int c=1,m=arr[0];
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i]>=m)
            {
              c++;
              m=arr[i];  
            }
        }
        return c;
    }
}
