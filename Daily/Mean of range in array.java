class Solution {
    public ArrayList<Integer> findMean(int[] arr, int[][] queries) {
        int n = arr.length;
        long[] pre = new long[n];
        pre[0] = arr[0];
        for (int i = 1; i < n; i++) pre[i] = pre[i - 1] + arr[i];
        ArrayList<Integer> res = new ArrayList<>();
        for (int[] q : queries) {
            long sum = (q[0] == 0) ? pre[q[1]] : pre[q[1]] - pre[q[0] - 1];
            res.add((int) (sum / (q[1] - q[0] + 1)));
        }
        return res;
    }
}
