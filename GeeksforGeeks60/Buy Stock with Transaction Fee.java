class Solution {
    public int maxProfit(int arr[], int k) {
        int n = arr.length;
        if (n <= 1) return 0;
        int hold = -arr[0]; 
        int free = 0;       

        for (int i = 1; i < n; i++) {
            int prevHold = hold;
            hold = Math.max(hold, free - arr[i]);
            free = Math.max(free, prevHold + arr[i] - k);
        }
        return free;
    }
}
