class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int len = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int size = set.size();
        int answer = 0;
        int start = 0;
        while (start < len) {
            set.clear();
            for (int i = start; i < len; i++) {
                set.add(nums[i]);
                if (set.size() == size) {
                    answer += (len - i);
                    break;
                }
            }
            
            start++;
        }

        return answer;
    }
}
