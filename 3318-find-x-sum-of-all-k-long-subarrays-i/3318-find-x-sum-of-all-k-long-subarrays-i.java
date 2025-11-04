class Solution {
    static final int MAX = 50;

    public int[] findXSum(int[] nums, int k, int x) {
        int len = nums.length;
        int[] answer = new int[len - k + 1];
        int[] cnt = new int[MAX + 1];

        for (int i = 0; i < k; i++) {
            cnt[nums[i]]++;
        }

        for (int i = 0; i <= len - k; i++) {
            int[][] arr = new int[MAX + 1][2];
            int idx = 0;
            for (int j = 0; j <= MAX; j++) {
                if (cnt[j] > 0) {
                    arr[idx][0] = j;
                    arr[idx++][1] = cnt[j];
                }
            }

            Arrays.sort(arr, 0, idx, (a, b) -> {
                if (a[1] != b[1]) return b[1] - a[1];
                return b[0] - a[0];
            });

            int sum = 0;
            for (int j = 0; j < Math.min(x, idx); j++)
                sum += arr[j][0] * arr[j][1];
            answer[i] = sum;

            if (i < len - k) {
                cnt[nums[i]]--;
                cnt[nums[i + k]]++;
            }
        }
        
        return answer;
    }
}
