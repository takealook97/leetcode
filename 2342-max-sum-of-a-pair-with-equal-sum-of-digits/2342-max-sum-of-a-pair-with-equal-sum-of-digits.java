class Solution {
    public int maximumSum(int[] nums) {
        int len = nums.length;
        int[][] arr = new int[len][2];
        for (int i = 0; i < len; i++) {
            arr[i][0] = nums[i];
            int sum = 0;
            while (nums[i] > 0) {
                sum += (nums[i] % 10);
                nums[i] /= 10;
            }
            arr[i][1] = sum;
        }

        Arrays.sort(arr, (a, b) -> {
            if (a[1] == b[1]) {
                return a[0] - b[0];
            }

            return a[1] - b[1];}
        );

        int answer = -1;
        for (int i = len - 1; i > 0; i--) {
            if (arr[i][1] == arr[i - 1][1]) {
                answer = Math.max(answer, arr[i][0] + arr[i - 1][0]);
            }
        }

        return answer;
    }
}
