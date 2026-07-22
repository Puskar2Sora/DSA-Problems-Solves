class Solution {
    public String reverseVowels(String s) {
     char[] m=s.toCharArray();
     int l=0,r=m.length-1;
     while(l<r)
     {
      while(l<r && !isVowel(m[l])) l++;
      while(l<r && !isVowel(m[r])) r--;   
      if(l<r)
      {
       char t=m[l];
       m[l]=m[r];
       m[r]=t;
       l++;
       r--;
      }
     }
     return new String(m);
    }
     private boolean isVowel(char c)
     {
        return c=='a'||c=='e'||c=='i'||c=='o'||c=='u'||c=='A'||c=='E'||c=='I'||c=='O'||c=='U';
     }
}