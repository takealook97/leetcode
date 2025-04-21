class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        int len = differences.length + 1;
        long[] arr = new long[len];
        long min = 0, max = 0;
        for (int i = 1; i < len; i++) {
            arr[i] = arr[i - 1] + differences[i - 1];
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }

        if (max - min <= upper - lower) {
            return (int) ((upper - lower) - (max - min) + 1);
        }

        return 0;
    }
}
