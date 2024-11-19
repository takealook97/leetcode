class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int N = nums.length, len = 0;
        long answer = 0;
        for (int num : nums) {
            len = Math.max(len, num);
        }

        int[] arr = new int[len + 1];

        int lo = 0, hi = k - 1;
        long sum = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= hi; i++) {
            arr[nums[i]]++;
            if(arr[nums[i]] > 1) {
                if(!list.contains(nums[i])) {
                    list.add(nums[i]);
                }
            }
            sum += nums[i];
        }

        if(list.isEmpty()) {
            answer = Math.max(answer, sum);
        }

        
        while (true) {        
            arr[nums[lo]]--;
            sum -= nums[lo];
            if(arr[nums[lo]] <= 1) {
                list.remove(Integer.valueOf(nums[lo]));
            }

            lo++;
            hi++;
            if(hi >= N) {
                break;
            }

            arr[nums[hi]]++;
            sum += nums[hi];
            if(arr[nums[hi]] > 1) {
                if(!list.contains(nums[hi])) {
                    list.add(nums[hi]);
                }
            }

            if (list.isEmpty()) {
                answer = Math.max(answer, sum);
            }
        }

        return answer;
    }
}
