import java.util.*;
class Solution {
    public String reverseWords(String s) {
        String[] w=s.trim().split("\\s+");
        List<String> l=Arrays.asList(w);
        Collections.reverse(l);
        String r=String.join(" ",l);
        return r;
    }
}