class Solution {
    public int totalWays(int[] arr, int target) {
        int totalSum=0;
        for (int num : arr) 
            totalSum +=num;
        if (Math.abs(target)>totalSum || (target+totalSum)%2!=0) 
            return 0;
        int subsetTarget=(target+totalSum)/2;
        if (subsetTarget<0) return 0;

        return countSubsets(arr,subsetTarget);
    }

    private int countSubsets(int[] arr, int s) {
        int[] dp = new int[s+1];
        dp[0] = 1; 
        for (int num : arr) {
            for (int j=s;j>=num; j--) {
                dp[j]+=dp[j - num];
            }
        }
        return dp[s];
    }
}
