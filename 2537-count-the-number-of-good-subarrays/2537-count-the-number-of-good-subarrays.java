class Solution {
    public long countGood(int[] nums, int k) {
        int len = nums.length, temp = 0, hi = -1;
        HashMap<Integer, Integer> map = new HashMap<>();
        long answer = 0;
        for (int lo = 0; lo < len; lo++) {
            while (temp < k && hi + 1 < len) {
                hi++;
                temp += map.getOrDefault(nums[hi], 0);
                map.put(nums[hi], map.getOrDefault(nums[hi], 0) + 1);
            }
            if (temp >= k) {
                answer += len - hi;
            }
            map.put(nums[lo], map.get(nums[lo]) - 1);
            temp -= map.get(nums[lo]);
        }

        return answer;
    }
}
