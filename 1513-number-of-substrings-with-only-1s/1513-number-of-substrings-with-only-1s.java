class Solution {
    static final int MOD = 1000000007;

    public int numSub(String s) {
        int len = s.length();
        long answer = 0;
        long count = 0;

        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '1') {
                count++;
            } else {
                if (count != 0) {
                    answer += count * (count + 1) / 2;
                    answer %= MOD;
                    count = 0;
                }
            }
        }

        if (count != 0) {
            answer += count * (count + 1) / 2;
        }

        return (int)(answer % MOD);
    }
}
