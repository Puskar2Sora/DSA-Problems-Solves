class Solution {
    public int smallestSubstring(String S) {
        int[] last = {-1, -1, -1};
        int res = S.length() + 1;
        
        for (int i = 0; i < S.length(); i++) {
            last[S.charAt(i) - '0'] = i;
            if (last[0] != -1 && last[1] != -1 && last[2] != -1) {
                int start = Math.min(last[0], Math.min(last[1], last[2]));
                res = Math.min(res, i - start + 1);
            }
        }
        return res > S.length() ? -1 : res;
    }
}

