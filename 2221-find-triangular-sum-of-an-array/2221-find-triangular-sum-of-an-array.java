class Solution {
    public int triangularSum(int[] nums) {
        List<Integer> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        for (int num : nums) {
            list.add(num);
        }

        int len;

        while (list.size() > 1) {
            len = list.size();
            for (int i = 0; i < len - 1; i++) {
                temp.add((list.get(i) + list.get(i + 1)) % 10);
            }
            list.clear();
            list.addAll(temp);
            temp.clear();
        }

        return list.get(0);
    }
}
