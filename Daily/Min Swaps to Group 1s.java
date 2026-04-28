class Solution {
    public int minSwaps(int[] arr) {
        int n = arr.length;
        int totalOnes = 0;
        for (int x : arr) {
            if (x == 1) totalOnes++;
        }
        if (totalOnes == 0) return -1;
        int currentZeros = 0;
        for (int i = 0; i < totalOnes; i++) {
            if (arr[i] == 0) currentZeros++;
        }
        int minSwaps = currentZeros;
      for (int i = totalOnes; i < n; i++) {
            if (arr[i] == 0) currentZeros++;
            if (arr[i - totalOnes] == 0) currentZeros--;
          minSwaps = Math.min(minSwaps, currentZeros);
        }
        return minSwaps;
    }
}
