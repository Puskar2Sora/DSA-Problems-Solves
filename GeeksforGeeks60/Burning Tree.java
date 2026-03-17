
import java.util.*;
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

class Solution {
    public int minTime(Node root, int target) {
        Map<Node, Node> parentMap = new HashMap<>();
        Node targetNode = findTargetAndMapParents(root, target, parentMap);
        return calculateBurnTime(targetNode, parentMap);
    }
    private Node findTargetAndMapParents(Node root, int target, Map<Node, Node> map) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        Node res = null;
        while (!q.isEmpty()) {
            Node curr = q.poll();
            if (curr.data == target) res = curr;
            if (curr.left != null) {
                map.put(curr.left, curr);
                q.add(curr.left);
            }
            if (curr.right != null) {
                map.put(curr.right, curr);
                q.add(curr.right);
            }
        }
        return res;
    }
    private int calculateBurnTime(Node targetNode, Map<Node, Node> parentMap) {
        Queue<Node> q = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        q.add(targetNode);
        visited.add(targetNode);
        int time = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            boolean burnedInThisStep = false;
            for (int i = 0; i < size; i++) {
                Node curr = q.poll();
                Node[] neighbors = {curr.left, curr.right, parentMap.get(curr)};
                for (Node neighbor : neighbors) {
                    if (neighbor != null && !visited.contains(neighbor)) {
                        burnedInThisStep = true;
                        visited.add(neighbor);
                        q.add(neighbor);
                    }
                }
            }
        if (burnedInThisStep) time++;
        }
        return time;
    }
}