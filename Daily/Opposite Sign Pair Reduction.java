class Solution {
    public ArrayList<Integer> reducePairs(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for (int curr : arr) {
            boolean destroyed = false;
            while (!stack.isEmpty() && ((stack.peek() > 0 && curr < 0) || (stack.peek() < 0 && curr > 0))) {
                int top = stack.peek();
                int absTop = Math.abs(top);
                int absCurr = Math.abs(curr);
                if (absTop < absCurr) {
                    stack.pop();
                    continue;
                } else if (absTop == absCurr) {
                    stack.pop();
                    destroyed = true;
                    break;
                }else {
                    destroyed = true;
                    break;
                }
            }
            if (!destroyed)  stack.push(curr);
        }
        return new ArrayList<>(stack);
    }
}
