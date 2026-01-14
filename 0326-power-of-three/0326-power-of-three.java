class Solution {
    public boolean isPowerOfThree(int n) {
        while (n != 1) {
            int mod = n % 3;
            if (mod != 0) {
                return false;
            }
            n /= 3;
        }

        return true;
    }
}
