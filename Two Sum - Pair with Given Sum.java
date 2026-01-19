class Solution {
    boolean twoSum(int arr[], int target) {
        // code here
        for(int i=0;i<arr.length;i++)
        {
            for(int j=i+1;j<arr.length;j++)
            {
                if((arr[i]+arr[j])== target)
                  return true;
            }
        }
        return false;
    }
}