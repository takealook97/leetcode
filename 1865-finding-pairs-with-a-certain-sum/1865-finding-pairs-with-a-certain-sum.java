class FindSumPairs {
    static int[] nums1, nums2;
    static Map<Integer, Integer> map;

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        map = new HashMap<>();

        for (int num : nums2) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
    }

    public void add(int index, int val) {
        int oldVal = nums2[index];
        int newVal = oldVal + val;

        map.put(oldVal, map.get(oldVal) - 1);
        if (map.get(oldVal) == 0) {
            map.remove(oldVal);
        }

        nums2[index] = newVal;
        map.put(newVal, map.getOrDefault(newVal, 0) + 1);
    }

    public int count(int tot) {
        int count = 0;
        for (int num : nums1) {
            count += map.getOrDefault(tot - num, 0);
        }
        return count;
    }
}
