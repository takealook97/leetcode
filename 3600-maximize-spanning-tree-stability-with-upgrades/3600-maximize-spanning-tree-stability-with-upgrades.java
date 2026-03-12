class Solution {

    static class DSU {
        int[] parent;
        int[] rank;

        DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }

        boolean union(int a, int b) {
            int pa = find(a);
            int pb = find(b);

            if (pa == pb) {
                return false;
            }

            if (rank[pa] < rank[pb]) {
                parent[pa] = pb;
            } else if (rank[pa] > rank[pb]) {
                parent[pb] = pa;
            } else {
                parent[pb] = pa;
                rank[pa]++;
            }

            return true;
        }
    }

    public int maxStability(int n, int[][] edges, int k) {
        int lo = 1;
        int hi = 200000;
        int answer = -1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (isPossible(n, edges, k, mid)) {
                answer = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return answer;
    }

    static boolean isPossible(int n, int[][] edges, int k, int x) {
        DSU dsu = new DSU(n);
        int used = 0;
        int upgrades = 0;

        List<int[]> normal = new ArrayList<>();
        List<int[]> upgrade = new ArrayList<>();

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            int s = e[2];
            int must = e[3];

            if (must == 1) {
                if (s < x) return false;

                if (dsu.union(u, v)) used++;
                else return false;
            } else {
                if (s >= x) normal.add(e);
                else if (s * 2 >= x) upgrade.add(e);
            }
        }

        for (int[] e : normal) {
            if (dsu.union(e[0], e[1])) {
                used++;
            }
        }

        for (int[] e : upgrade) {
            if (used == n - 1) break;
            if (upgrades == k) break;

            if (dsu.union(e[0], e[1])) {
                used++;
                upgrades++;
            }
        }

        return used == n - 1;
    }
}
