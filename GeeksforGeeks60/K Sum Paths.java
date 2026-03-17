/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/
import java.util.*;
class Solution {
    public int countAllPaths(Node root, int k) {
        // code here
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0, 1);
        
        return backtrack(root, 0, k, prefixSumMap);
    }
    private int backtrack(Node node, int currentSum, int k, HashMap<Integer, Integer> map) {
        if (node == null) {
            return 0;
        }

        int totalPaths = 0;
        currentSum += node.data;
        totalPaths += map.getOrDefault(currentSum - k, 0);
        map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
        totalPaths += backtrack(node.left, currentSum, k, map);
        totalPaths += backtrack(node.right, currentSum, k, map);
        map.put(currentSum, map.get(currentSum) - 1);

        return totalPaths;
    }
}