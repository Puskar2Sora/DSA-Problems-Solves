import java.util.*;
class Solution {
    public static ArrayList<Integer> findUnion(int[] a, int[] b) {
        
        HashSet<Integer> set = new HashSet<>();
        for(int num : a) 
            set.add(num);
        
        for(int num : b)
            set.add(num);
        
        return new ArrayList<>(set);
    }
}