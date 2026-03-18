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

class Solution {
        int moves = 0;
    public int distCandy(Node root) {
        // code here
        moves = 0;
        calculateExcess(root);
        return moves;
    }
    private int calculateExcess(Node node) {
        if (node == null) return 0;
        int leftExcess = calculateExcess(node.left);
        int rightExcess = calculateExcess(node.right);
        moves += Math.abs(leftExcess) + Math.abs(rightExcess);
        return node.data + leftExcess + rightExcess - 1;
    }
    
}