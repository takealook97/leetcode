class Solution {
    public long continuousSubarrays(int[] nums) {
        int len = nums.length;
        long answer = 0;
        
        int lo = 0;
        int min = nums[0], max = nums[0];

        for (int hi = 0; hi < len; hi++) {
            min = Math.min(min, nums[hi]);
            max = Math.max(max, nums[hi]);
            while (max - min > 2) {
                lo++;
                min = nums[lo];
                max = nums[lo];
                for (int i = lo; i <= hi; i++) {
                    min = Math.min(min, nums[i]);
                    max = Math.max(max, nums[i]);
                }
            }

            answer += (hi - lo + 1);
        }

        return answer;
    }
}
