class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        List<int[]>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            adj[edge[0]].add(new int[]{edge[1], edge[2]});
        }

        int[][] dist = new int[n][k + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        
        dist[0][1] = 0;
        pq.offer(new int[]{0, 0, 1});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int weight = curr[0];
            int u = curr[1];
            int count = curr[2];

            if (weight > dist[u][count]) continue;

            if (u == n - 1) return weight;

            for (int[] next : adj[u]) {
                int v = next[0];
                int w = next[1];

                int nextCount = (labels.charAt(u) == labels.charAt(v)) ? count + 1 : 1;

                if (nextCount <= k) {
                    if (weight + w < dist[v][nextCount]) {
                        dist[v][nextCount] = weight + w;
                        pq.offer(new int[]{weight + w, v, nextCount});
                    }
                }
            }
        }

        return -1;
    }
}