class Solution {
    public boolean canSplit(int arr[]) {
        int totalSum = 0;
        for (int i: arr)
            totalSum +=i;
        if (totalSum % 2 != 0) return false;
        int target = totalSum / 2;
        int leftSum = 0;
        for (int i = 0; i < arr.length; i++) {
            leftSum += arr[i];
            if (leftSum == target) return true;
            if (leftSum > target)  return false;
        }
        return false;
    }
}
