class Solution {
    public boolean isBinaryPalindrome(int n) {
        String b = Integer.toBinaryString(n);
        int l=0, r=b.length() - 1;
        while (l<r) {
            if (b.charAt(l)!=b.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}
