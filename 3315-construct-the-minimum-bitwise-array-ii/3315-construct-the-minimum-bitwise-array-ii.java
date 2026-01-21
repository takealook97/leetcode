class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int len = nums.size();
        int[] answer = new int[len];

        for (int i = 0; i < len; i++) {
            int v = nums.get(i);
            if ((v & 1) == 0) {
                answer[i] = -1;
                continue;
            }

            int t = 0;
            int tmp = v;
            while ((tmp & 1) == 1) {
                t++;
                tmp >>= 1;
            }

            answer[i] = v - (1 << (t - 1));
        }

        return answer;
    }
}
