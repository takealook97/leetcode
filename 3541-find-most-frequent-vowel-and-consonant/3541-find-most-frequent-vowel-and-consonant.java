class Solution {
    static Set<Integer> set = Set.of(0, 4, 8, 14, 20);

    public int maxFreqSum(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        int a = 0, b = 0;
        for (int i = 0; i < 26; i++) {
            if (set.contains(i)) {
                a = Math.max(a, count[i]);
            } else {
                b = Math.max(b, count[i]);
            }
        }

        return a + b;
    }
}
