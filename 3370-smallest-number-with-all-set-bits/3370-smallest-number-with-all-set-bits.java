class Solution {
    public int smallestNumber(int n) {
        int[] arr = new int[11];
        arr[0] = 1;
        for (int i = 1; i <= 10; i++) {
            arr[i] = arr[i - 1] * 2;
        }

        for (int i = 0; i <= 10; i++) {
            if (n < arr[i]) {
                return arr[i] - 1;
            }
        }

        return 0;
    }
}
