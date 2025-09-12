class Solution {
    static final Set<Character> VOWELS = Set.of('a','e','i','o','u');

    public boolean doesAliceWin(String s) {
        int vowelCount = 0, consonantCount;
        for (char c : s.toCharArray()) {
            if (VOWELS.contains(c)) {
                vowelCount++;
            }
        }
        consonantCount = s.length() - vowelCount;

        if (vowelCount == 0 || consonantCount == 0) {
            if (consonantCount == 0 && vowelCount % 2 == 0) {
                return true;
            }
            return vowelCount % 2 == 1;
        }

        return true;
    }
}
