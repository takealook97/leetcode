class Solution {
    static final int EVEN = 0, ODD = 1, MOD = 1000000007;
    
    public int numOfSubarrays(int[] arr) {
        int len = arr.length, evenCount = 0, oddCount = 0, answer = 0;
        int[] sum = new int[len];
        int[][] count = new int[2][len];

        sum[0] = arr[0];
        if (sum[0] % 2 == 0) {
            count[EVEN][0]++;
        } else {
            count[ODD][0]++;
            answer++;
        }

        for (int i = 1; i < len; i++) {
            sum[i] = sum[i - 1] + arr[i];
            count[EVEN][i] += count[EVEN][i - 1];
            count[ODD][i] += count[ODD][i - 1];

            if (sum[i] % 2 == 0) {
                count[EVEN][i]++;
                answer = (answer + count[ODD][i]) % MOD;
            } else {
                count[ODD][i]++;
                answer = (answer + (1 + count[EVEN][i])) % MOD;
            }
        }

        return answer;
    }
}
