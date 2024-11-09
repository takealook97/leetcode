class Solution {
    public long minEnd(int n, int x) {
        long answer = x;

        for (int i = 1; i < n; i++) {
            answer = (answer + 1) | x;
        }

        return answer;
    }
}
