class Solution {
    public long countBadPairs(int[] nums) {
        int len = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int key = nums[i] - i;
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        
        if (map.size() == 1) {
            return 0;
        }

        long sum = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int v : map.values()) {
            sum += v;
            if (v > 1) {
                list.add(v);
            }
        }

        long answer = sum * (sum - 1) / 2;
        for (int i : list) {
            answer -= (i * (i - 1) / 2);
        }

        return answer;
    }
}
