class Solution {
    static int N;
    static Map<Integer, Integer> map;

    public boolean canSortArray(int[] nums) {
        N = nums.length;
        map = new HashMap<>();

        setMap(nums);

        for (int lo = 0; lo < N - 1; lo++) {
            for (int hi = lo + 1; hi < N; hi++) {
                if (nums[lo] > nums[hi]) {
                    if (map.get(nums[lo]) != map.get(nums[hi])) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    static void setMap(int[] nums) {
        String binary;
        int len, count;
        for (int num : nums) {
            if (!map.containsKey(num)) {
                binary = Integer.toBinaryString(num);
                len = binary.length();
                count = 0;
                for (int i = 0; i < len; i++) {
                    if(binary.charAt(i) == '1') {
                        count++;
                    }
                }
                map.put(num, count);
            }
        }
    }
}
