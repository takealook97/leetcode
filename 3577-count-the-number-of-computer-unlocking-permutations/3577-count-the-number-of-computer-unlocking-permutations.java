class Solution {
    static final int MOD = 1000000007;

    public int countPermutations(int[] complexity) {
        int len = complexity.length;
        for (int i = 1; i < len; i++) {
            if (complexity[i] <= complexity[0]) {
                return 0;
            }
        }

        int answer = 1;
        for (int i = 2; i < len; i++) {
            answer = (int) (((long) answer * i) % MOD);
        }

        return answer;
    }
}
