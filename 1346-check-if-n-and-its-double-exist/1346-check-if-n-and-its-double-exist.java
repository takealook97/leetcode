class Solution {
    static int len;
    static int[] arr;

    public boolean checkIfExist(int[] arr) {
        len = arr.length;
        if (len <= 1) {
            return false;
        }

        Arrays.sort(arr);
        this.arr = arr;

        int idx = 0;
        for (int lo = 0; lo < len - 1; lo++) {
            if (arr[lo] > 0) {
                idx = lowerBound(lo + 1, arr[lo] * 2);
                if (idx < len && arr[lo] * 2 == arr[idx]) {
                    return true;
                }
            } else {
                if (arr[lo] % 2 == 0) {
                    idx = lowerBound(lo + 1, arr[lo] / 2);
                    if (idx < len && arr[lo] / 2 == arr[idx]) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    static int lowerBound(int lo, int target) {
        int hi = len - 1, mid;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (arr[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return lo;
    }
}
