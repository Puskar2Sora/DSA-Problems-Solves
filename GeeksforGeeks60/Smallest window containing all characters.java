import java.util.*;
class Solution {
    public static String minWindow(String s, String p) {
     if (s==null || p==null || s.length()<p.length() || p.length()==0)
            return "";
            
        HashMap<Character, Integer> targetFreq = new HashMap<>();
        
        for (char c :p.toCharArray())
            targetFreq.put(c, targetFreq.getOrDefault(c, 0) + 1);

        HashMap<Character, Integer> windowFreq = new HashMap<>();
        int left=0, right=0, formed=0,minStart=0;
        int required=targetFreq.size(); 
        int minLen=Integer.MAX_VALUE;

        while (right < s.length()) {
            char charRight = s.charAt(right);
            windowFreq.put(charRight, windowFreq.getOrDefault(charRight, 0) + 1);

            if (targetFreq.containsKey(charRight) && windowFreq.get(charRight).equals(targetFreq.get(charRight))) 
                formed++;

            while (left<=right && formed==required) {
                if (right - left + 1 <minLen) {
                    minLen=right - left + 1;
                    minStart=left;
                }

                char charLeft=s.charAt(left);
                windowFreq.put(charLeft, windowFreq.get(charLeft) - 1);
               if (targetFreq.containsKey(charLeft) && windowFreq.get(charLeft) < targetFreq.get(charLeft)) 
                    formed--;
                left++;
            }
            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);   
    }
}