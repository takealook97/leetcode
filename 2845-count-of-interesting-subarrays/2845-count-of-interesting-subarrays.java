class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        int len = nums.size();
        int[] count = new int[len];
        int idx = 0;
        for (int num : nums) {
            if (idx > 0) {
                count[idx] += count[idx - 1];
            }
            count[idx++] += (num % modulo == k ? 1 : 0);
        }

        Map<Integer, Long> map = new HashMap<>();
        map.put(0, 1L);
        long answer = 0;
        for (int i = 0; i < len; i++) {
            int mod = ((count[i] - k) % modulo + modulo) % modulo;
            answer += map.getOrDefault(mod, 0L);
            int cur = count[i] % modulo;
            map.put(cur, map.getOrDefault(cur, 0L) + 1);
        }

        return answer;
    }
}
