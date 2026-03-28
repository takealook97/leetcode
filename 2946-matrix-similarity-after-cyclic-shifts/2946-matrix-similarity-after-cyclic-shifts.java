class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int n = mat.length;
        int m = mat[0].length;
        if (k % m == 0) {
            return true;
        }

        Deque<Integer>deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            deque.clear();
            for (int j = 0; j < m; j++) {
                deque.add(mat[i][j]);
            }

            int time = k;
            while (time-- > 0) {
                if (i % 2 == 0) {
                    deque.addLast(deque.pollFirst());
                } else {
                    deque.addFirst(deque.pollLast());
                }
            }

            for (int j = 0; j < m; j++) {
                if (mat[i][j] != deque.pollFirst()) {
                    return false;
                }
            }
        }

        return true;
    }
}