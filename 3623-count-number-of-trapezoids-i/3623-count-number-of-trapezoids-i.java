class Solution {
    static final int MOD = 1000000007;

    public int countTrapezoids(int[][] points) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] point : points) {
            map.put(point[1], map.getOrDefault(point[1], 0) + 1);
        }

        long answer = 0, sum = 0;
        for (int num : map.values()) {
            long edge = ((long) num * (num - 1)) / 2;
            answer = (answer + edge * sum) % MOD;
            sum = (sum + edge) % MOD;
        }

        return (int) answer;
    }
}