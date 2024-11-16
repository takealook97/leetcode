class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int len = nums.length;
        int[] answer = new int[len - k + 1];
        for (int i = 0; i <= len - k; i++) {
            boolean check = true;
            for (int j = i; j < i + k - 1; j++) {
                if (nums[j] + 1 != nums[j + 1]) {
                    check = false;
                    break;
                }
            }
            answer[i] = check ? nums[i + k - 1] : -1;
        }
        return answer;
    }
}
