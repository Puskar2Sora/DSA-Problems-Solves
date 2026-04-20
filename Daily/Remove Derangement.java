class Solution {
    public int derangeCount(int n) {
        // Base cases
        if (n == 1) return 0; // Only one element [1], cannot be deranged
        if (n == 2) return 1; // [1, 2] -> [2, 1] is the only derangement

        // Since n is small (up to 12), we can use an array for DP
        int[] dp = new int[n + 1];

        // Initializing base values
        dp[1] = 0;
        dp[2] = 1;

        // Fill the DP table using the recurrence relation:
        // D(n) = (n - 1) * [D(n - 1) + D(n - 2)]
        for (int i = 3; i <= n; i++) {
            dp[i] = (i - 1) * (dp[i - 1] + dp[i - 2]);
        }

        return dp[n];
    }
}

