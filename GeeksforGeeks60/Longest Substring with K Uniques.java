import java.util.*;
class Solution {
    public int longestKSubstr(String s, int k) {
        int i=0,j=0,l=-1;
        HashMap<Character,Integer> h=new HashMap<>();
        
        while(j<s.length())
        {
            char r=s.charAt(j);
            h.put(r, h.getOrDefault(r,0)+1);
            
            while(h.size()>k)
            {
                char lr=s.charAt(i);
                h.put(lr,h.get(lr)-1);
                if(h.get(lr)==0)
                 h.remove(lr);
                i++;
            }
            if(h.size()==k)
              l=Math.max(l,j-i+1);
            j++;
        }
     return l;
    }
}