class Solution {
    public int countValidSelections(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0] == 0 ? 2 : 0;
        }

        int[] sumArr = new int[len];
        sumArr[0] = nums[0];
        for (int i = 1; i < len; i++) {
            sumArr[i] = sumArr[i - 1] + nums[i];
        }

        int max = sumArr[len - 1];
        int answer = 0;

        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                int left = (i > 0) ? sumArr[i - 1] : 0;
                int right = max - left;
                int diff = Math.abs(left - right);

                if (diff == 0) {
                    answer += 2;
                } else if (diff == 1) {
                    answer += 1;
                }
            }
        }

        return answer;
    }
}
