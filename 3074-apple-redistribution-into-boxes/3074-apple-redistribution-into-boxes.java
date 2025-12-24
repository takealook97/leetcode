class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int sum = 0;
        for (int a : apple) {
            sum += a;
        }

        int len = capacity.length;
        Arrays.sort(capacity);
        for (int i = len - 1; i >= 0; i--) {
            sum -= capacity[i];
            if (sum <= 0) {
                return len - i;
            }
        }

        return -1;
    }
}