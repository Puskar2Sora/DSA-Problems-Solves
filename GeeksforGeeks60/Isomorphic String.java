import java.util.*;
class Solution {
    public boolean areIsomorphic(String s1, String s2) {
        
    for (int i = 0; i < s1.length(); i++)
    {
        if (s1.indexOf(s1.charAt(i)) != s2.indexOf(s2.charAt(i))) 
            return false;
    }
    return true;
  }
}