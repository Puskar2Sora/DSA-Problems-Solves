class Solution {
    public int minSteps(int m, int n, int d) {
        if (d > m && d > n) return -1;
        if (d % gcd(m, n) != 0) return -1;
        return Math.min(solve(m, n, d), solve(n, m, d));
    }
    private int solve(int fromCap, int toCap, int target) {
        int from = fromCap; // Fill the first jug
        int to = 0;
        int steps = 1;

        while (from != target && to != target) {
            int temp = Math.min(from, toCap - to);
            to += temp;
            from -= temp;
            steps++;
            if (from == target || to == target) break;
            if (from == 0) {
                from = fromCap;
                steps++;
            }
            if (to == toCap) {
                to = 0;
                steps++;
            }
        }
        return steps;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
