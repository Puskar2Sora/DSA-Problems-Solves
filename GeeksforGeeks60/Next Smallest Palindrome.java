class Solution {
    static int[] nextPalindrome(int[] num) {
        int n = num.length;
        if (all(num)) {
            int[] res = new int[n + 1];
            res[0] = 1;
            res[n] = 1;
            return res;
        }
        int mid = n / 2;
        int i = mid - 1;
        int j = (n % 2 == 0) ? mid : mid + 1;
        while (i >= 0 && num[i] == num[j]) {
            i--;
            j++;
        }
        boolean leftSmaller = false;
        if (i < 0 || num[i] < num[j]) {
            leftSmaller = true;
        }
        while (i >= 0) {
            num[j] = num[i];
            i--;
            j++;
        }
        if (leftSmaller) {
            int carry = 1;
            i = mid - 1;
            if (n % 2 == 1) { 
                num[mid] += carry;
                carry = num[mid] / 10;
                num[mid] %= 10;
                j = mid + 1;
            } else  j=mid;
            while (i >= 0) {
                num[i] += carry;
                carry = num[i] / 10;
                num[i] %= 10;
                num[j] = num[i]; 
                i--;
                j++;
            }
        }
        return num;
    }

    static boolean all(int[] num) {
        for (int x : num) if (x != 9) return false;
        return true;
    }
}
