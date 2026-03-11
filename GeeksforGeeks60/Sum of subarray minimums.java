class Solution {
    public int sumSubMins(int[] arr) {
        int n = arr.length;
        long totalSum = 0;
        long mod = 1000000007;
     int[] left = new int[n];
        int[] right = new int[n];
        int[] stack = new int[n];
        int top = -1;
        for (int i = 0; i < n; i++) {
            while (top != -1 && arr[stack[top]] > arr[i]) top--;
            left[i] = (top == -1) ? (i + 1) : (i - stack[top]);
            stack[++top] = i;
        }
        top = -1; 
        for (int i = n - 1; i >= 0; i--) {
            while (top != -1 && arr[stack[top]] >= arr[i]) top--;
            right[i] = (top == -1) ? (n - i) : (stack[top] - i);
            stack[++top] = i;
        }
        for (int i = 0; i < n; i++) {
            long count = (long) left[i] * right[i];
            totalSum = (totalSum + (count % mod * arr[i] % mod)) % mod;
        }

        return (int) totalSum;
    }
}