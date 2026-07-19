class Solution {
    public String mergeAlternately(String word1, String word2) {
     StringBuilder r = new StringBuilder();
     int a=word1.length();
     int b=word2.length();
     for(int i=0;i<a || i<b;i++)
     {
        if(i<a)
          r.append(word1.charAt(i));
        if(i<b)
          r.append(word2.charAt(i));
     }
     return r.toString();
    }
}