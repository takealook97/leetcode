class Solution {
    static final int SIZE = 26;

    public boolean canConstruct(String s, int k) {
        if (s.length() < k) {
            return false;
        }

        int[] count = new int[SIZE];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        int evenCount = 0;
        int oneCount = 0;

        for (int i : count) {
            evenCount += (i / 2);
            oneCount += (i % 2);
        }

        return oneCount <= k;
    }
}
