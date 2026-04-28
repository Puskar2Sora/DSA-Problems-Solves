class Solution {
    public int longestSubstr(String s, int k) {
        int[] count = new int[26]; 
        int m=0,l=0,ml=0; 
        for (int i= 0; i<s.length(); i++) {
            count[s.charAt(i) - 'A']++;
            m= Math.max(m,count[s.charAt(i) - 'A']);
            while ((i-l + 1)-m> k) {
                count[s.charAt(l) - 'A']--;
                l++;
            }
        ml= Math.max(ml,i-l+1);
        }
        return ml;
    }
}
