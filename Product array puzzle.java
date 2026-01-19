// User function Template for Java
class Solution {
    public static int[] productExceptSelf(int arr[]) {
        // code here
     int n = arr.length;
        int[] res = new int[n];

        // left product
        int left = 1;
        for (int i = 0; i < n; i++) {
            res[i] = left;
            left *= arr[i];
        }

        // right product
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] = res[i] * right;
            right *= arr[i];
        }
        return res;
    }
}
