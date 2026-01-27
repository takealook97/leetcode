class Solution {
    static class Edge {
        int to, cost;
        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    static class State implements Comparable<State> {
        int node;
        long dist;

        State(int node, long dist) {
            this.node = node;
            this.dist = dist;
        }

        @Override
        public int compareTo(State o) {
            return Long.compare(this.dist, o.dist);
        }
    }

    public int minCost(int n, int[][] edges) {
        List<Edge>[] arr = new ArrayList[n];
        List<Edge>[] rev = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            arr[i] = new ArrayList<>();
            rev[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            arr[u].add(new Edge(v, w));
            rev[v].add(new Edge(u, w));
        }

        long INF = Long.MAX_VALUE / 4;
        long[] dist = new long[n];
        Arrays.fill(dist, INF);

        PriorityQueue<State> pq = new PriorityQueue<>();
        dist[0] = 0;
        pq.add(new State(0, 0));

        while (!pq.isEmpty()) {
            State cur = pq.poll();
            int u = cur.node;

            if (cur.dist != dist[u]) continue;

            for (Edge e : arr[u]) {
                if (dist[e.to] > cur.dist + e.cost) {
                    dist[e.to] = cur.dist + e.cost;
                    pq.add(new State(e.to, dist[e.to]));
                }
            }

            for (Edge e : rev[u]) {
                long nd = cur.dist + 2L * e.cost;
                if (dist[e.to] > nd) {
                    dist[e.to] = nd;
                    pq.add(new State(e.to, nd));
                }
            }
        }

        return dist[n - 1] == INF ? -1 : (int) dist[n - 1];
    }
}
