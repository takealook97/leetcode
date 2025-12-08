class Solution {
    public int countTriples(int n) {
        int answer = 0;
        for (int i = 1; i <= n - 1; i++) {
            for (int j = i + 1; j <= n; j++) {
                double k = Math.sqrt(i * i + j * j);
                if (k <= n && (int) k == k) {
                    answer += 2;
                }
            }
        }

        return answer;
    }
}
