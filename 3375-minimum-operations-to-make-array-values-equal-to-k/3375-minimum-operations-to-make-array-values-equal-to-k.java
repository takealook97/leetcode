class Solution {
    public int minOperations(int[] nums, int k) {
        int len = nums.length;
        Arrays.sort(nums);
        if (nums[0] < k) {
            return -1;
        }

        int answer = 0;
        if (k < nums[0]) {
            answer++;
        }
        
        for (int i = 0; i < len - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                answer++;
            }
        }

        return answer;
    }
}
