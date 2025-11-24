class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> answer = new ArrayList<>();
        int cur = 0;
        for (int num : nums) {
            cur = (cur * 2 + (num == 1 ? 1 : 0)) % 10;
            if (cur % 5 == 0) {
                answer.add(true);
            } else {
                answer.add(false);
            }
        }

        return answer;
    }
}
