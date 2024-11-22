class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String, Integer> map = new HashMap<>();
        for (int[] row : matrix) {
            StringBuilder prev = new StringBuilder();
            StringBuilder after = new StringBuilder();

            for (int bit : row) {
                prev.append(bit);
                after.append(1 - bit);
            }
            
            String prevKey = prev.toString();
            String afterKey = after.toString();
            map.put(prevKey, map.getOrDefault(prevKey, 0) + 1);
            map.put(afterKey, map.getOrDefault(afterKey, 0) + 1);
        }

        int after = 0;
        for (int count : map.values()) {
            after = Math.max(after, count);
        }

        return after;
    }
}
