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

        int oneCount = 0;
        for (int i : count) {
            oneCount += (i % 2);
        }

        return oneCount <= k;
    }
}
