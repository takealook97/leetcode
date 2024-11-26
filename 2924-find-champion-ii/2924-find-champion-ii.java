class Solution {
    static int n;
    static int[] parent, degree;

    static final int WIN = 0, LOSE = 1;

    public int findChampion(int n, int[][] edges) {
        this.n = n;
        make();

        degree = new int[n];
        for (int[] edge : edges) {
            degree[edge[LOSE]]++;
            union(edge[WIN], edge[LOSE]);
        }

        int champion = -1;
        for (int i = 0; i < n; i++) {
            if (degree[i] == 0) {
                if (champion != -1) {
                    return -1;
                }
                champion = i;
            }
        }

        if (champion == -1) {
            return -1;
        }

        int root = find(champion);
        for (int i = 0; i < n; i++) {
            if (find(i) != root) {
                return -1;
            }
        }

        return champion;
    }

    static void make() {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    static boolean union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            parent[y] = x;
            return true;
        }
        return false;
    }

    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }
}
