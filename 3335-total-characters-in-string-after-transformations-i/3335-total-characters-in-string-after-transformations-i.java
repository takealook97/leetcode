class Solution {
    static final int MOD = 1000000007;
    
    public int lengthAfterTransformations(String s, int t) {
        long len = s.length();
        long[] arr = new long[26];
        for (char c : s.toCharArray()) {
            arr[c - 'a']++;
        }

        for (int i = 0; i < t; i++) {
            long count = arr[25];
            for (int j = 25; j > 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[0] = count;
            arr[1] = (arr[1] + count) % MOD;
            len = (len + count) % MOD;
        }

        return (int) len;
    }
}
