class Solution {
    static final int SIZE = 26;
    static long INF = Long.MAX_VALUE / 2;

    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        long[][] arr = new long[SIZE][SIZE];
        int len = original.length;
        for (int i = 0; i < SIZE; i++) {
            Arrays.fill(arr[i], INF);
            arr[i][i] = 0L;
        }
        for (int i = 0; i < len; i++) {
            arr[original[i] - 'a'][changed[i] - 'a'] = Math.min(arr[original[i] - 'a'][changed[i] - 'a'], cost[i]);
        }

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                for (int k = 0; k < SIZE; k++) {
                    arr[j][k] = Math.min(arr[j][k], arr[j][i] + arr[i][k]);
                }
            }
        }

        len = source.length();
        long answer = 0L;
        for (int i = 0; i < len; i++) {
            int from = source.charAt(i) - 'a';
            int to = target.charAt(i) - 'a';
            if (from == to) {
                continue;
            }
            if (arr[from][to] >= INF) {
                return -1L;
            }

            answer += arr[from][to];
        }

        return answer;
    }
}
