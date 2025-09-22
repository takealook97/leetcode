class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] count = new int[101];
        for (int num : nums) {
            count[num]++;
        }

        Arrays.sort(count);
        int max = count[100];
        int answer = 0;
        for (int i = 100; i >= 1; i--) {
            if (max == count[i]) {
                answer += count[i];
            } else {
                break;
            }
        }

        return answer;
    }
}
