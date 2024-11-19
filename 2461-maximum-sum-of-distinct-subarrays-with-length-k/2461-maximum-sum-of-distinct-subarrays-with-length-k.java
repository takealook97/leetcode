class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int len = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        long answer = 0, sum = 0;

        int lo = 0;
        for (int hi = 0; hi < len; hi++) {
            map.put(nums[hi], map.getOrDefault(nums[hi], 0) + 1);
            sum += nums[hi];

            if (hi - lo + 1 > k) {
                map.put(nums[lo], map.get(nums[lo]) - 1);
                if (map.get(nums[lo]) == 0) {
                    map.remove(nums[lo]);
                }
                sum -= nums[lo];
                lo++;
            }

            if (hi - lo + 1 == k && map.size() == k) {
                answer = Math.max(answer, sum);
            }
        }

        return answer;
    }
}
