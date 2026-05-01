import java.util.*;

class Solution {
    static ArrayList<Integer> kthLargest(int[] arr, int k) {
        PriorityQueue<Integer> min = new PriorityQueue<>();
        ArrayList<Integer> r= new ArrayList<>();
        for (int i : arr) {
            min.add(i);
            if (min.size()>k) min.poll();
            if (min.size()<k) r.add(-1);
            else r.add(min.peek());
        }
        return r;
    }
}
