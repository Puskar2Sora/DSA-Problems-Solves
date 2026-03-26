import java.util.*;

class Solution {
    static class Pair {
        int node;
        long time;
        Pair(int node, long time) {
            this.node = node;
            this.time = time;
        }
    }
    public int countPaths(int n, int[][] roads) {
        long mod = (long) (1e9 + 7);
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] road : roads) {
            adj.get(road[0]).add(new Pair(road[1], road[2]));
            adj.get(road[1]).add(new Pair(road[0], road[2]));
        }
    long[] dist = new long[n];
        long[] ways = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Long.compare(a.time, b.time));
        pq.add(new Pair(0, 0));
        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int u = current.node;
            long d = current.time;
            if (d > dist[u]) continue;
            for (Pair neighbor : adj.get(u)) {
                int v = neighbor.node;
                long weight = neighbor.time;
                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    ways[v] = ways[u];
                    pq.add(new Pair(v, dist[v]));
                } else if (dist[u] + weight == dist[v]) {
                    ways[v] = (ways[v] + ways[u]) % mod;
                }
            }
        }

        return (int) ways[n - 1];
    }
}