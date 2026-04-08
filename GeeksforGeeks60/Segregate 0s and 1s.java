class Solution {
    void segregate0and1(int[] arr) {
        int left=0;
        int right= arr.length - 1;

        while (left<right) {
            while (arr[left]==0 && left<right)
            left++;
            while (arr[right] == 1 && left<right) 
                right--;
            if (left<right) {
                arr[left]=0;
                arr[right]=1;
                left++;
                right--;
            }
        }
    }
}
