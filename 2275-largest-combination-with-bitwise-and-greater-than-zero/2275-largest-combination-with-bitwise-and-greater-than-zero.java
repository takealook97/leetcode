class Solution {
    static final int LIMIT = 25;

    public int largestCombination(int[] candidates) {
        int N = candidates.length;
        int answer = 0;

        int[] count = new int[LIMIT];

        String binary;
        int len;
        for (int num : candidates) {
            binary = Integer.toBinaryString(num);
            len = binary.length();
            for (int i = len - 1; i >= 0; i--) {
                if(binary.charAt(i) == '1') {
                    count[len - 1 - i]++;
                }
            }
        }

        for (int i : count) {
            answer = Math.max(answer, i);
        }

        return answer;
    }
}
