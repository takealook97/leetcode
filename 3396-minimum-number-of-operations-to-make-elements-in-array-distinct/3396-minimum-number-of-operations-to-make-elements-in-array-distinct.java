class Solution {
    static final int LIMIT = 100;

    public int minimumOperations(int[] nums) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Set<Integer> set = new HashSet<>(map.values());
        if (set.size() <= 1 && map.values().iterator().next() == 1) {
            return 0;
        }

        int answer = 0;
        for (int i = 0; i < len; i += 3) {
            answer++;
            for (int j = i; j < i + 3 && j < len; j++) {
                int val = map.get(nums[j]);
                if (val == 1) {
                    map.remove(nums[j]);
                } else {
                    map.put(nums[j], val - 1);
                }

                set.clear();
                set.addAll(map.values());
                if (set.size() <= 1 && map.values().iterator().next() == 1) {
                    return answer;
                }
            }
        }

        return answer;
    }
}
