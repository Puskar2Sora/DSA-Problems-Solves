class Solution {
    boolean pythagoreanTriplet(int[] arr) {
        int max = 0;
        for (int x : arr) {
            if (x > max) max = x;
        }

        boolean[] exists = new boolean[max + 1];
        for (int x : arr) {
            exists[x] = true;
        }
        for (int i = 1; i <= max; i++) {
            if (!exists[i]) continue;

            for (int j = i + 1; j <= max; j++) {
                if (!exists[j]) continue;
                 int val = i * i + j * j;
                int c = (int) Math.sqrt(val);
                if (c * c == val && c <= max && exists[c]) {
                    return true;
                }
            }
        }

        return false;
    }
}