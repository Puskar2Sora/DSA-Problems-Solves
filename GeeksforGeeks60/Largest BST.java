// class Node
// {
//     int data;
//     Node left, right;

//     public Node(int d)
//     {
//         data = d;
//         left = right = null;
//     }
// }
class NodeInfo {
    int size;
    int maxVal;
    int minVal;
    boolean isBST;
    NodeInfo(int size, int maxVal, int minVal, boolean isBST) {
        this.size = size;
        this.maxVal = maxVal;
        this.minVal = minVal;
        this.isBST = isBST;
    }
}
class Solution {
    static int maxSize;
    static int largestBst(Node root) {
        maxSize = 0;
        solve(root);
        return maxSize;
    }
    static NodeInfo solve(Node root) {
        if (root == null) 
            return new NodeInfo(0, Integer.MIN_VALUE, Integer.MAX_VALUE, true);
       NodeInfo left = solve(root.left);
        NodeInfo right = solve(root.right);
        if (left.isBST && right.isBST && root.data > left.maxVal && root.data < right.minVal) {
            int currentSize = 1 + left.size + right.size;
            maxSize = Math.max(maxSize, currentSize);
            return new NodeInfo(
                currentSize,
                Math.max(root.data, right.maxVal), 
                Math.min(root.data, left.minVal),  
                true
            );
        }
        return new NodeInfo(0, 0, 0, false);
    }
}