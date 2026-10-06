class Solution {
    public String mergeAlternately(String word1, String word2) {
     StringBuilder r = new StringBuilder();
     for(int i=0;i<word1.length() || i<word2.length();i++)
     {
        if(i<word1.length())
          r.append(word1.charAt(i));
        if(i<word2.length())
          r.append(word2.charAt(i));
     
     return r.toString();
    }
}
