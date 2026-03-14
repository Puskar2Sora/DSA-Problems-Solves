class Pair {
    Node node;
    int hd;
    Pair(Node node, int hd) {
        this.node = node;
        this.hd = hd;
    }
}

class Solution {
    public ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> r = new ArrayList<>();
        if (root == null) return r;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));
        
        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            Node temp = current.node;
            int hd = current.hd;
            if (!map.containsKey(hd)) map.put(hd, temp.data);
            if (temp.left != null)  queue.add(new Pair(temp.left, hd - 1));
            if (temp.right != null) queue.add(new Pair(temp.right, hd + 1));
        }
        for (int i : map.values())
            r.add(i);
        return r;
    }
}