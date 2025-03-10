class Solution {
    static final String VOWELS = "aeiou";

    public static long countOfSubstrings(String word, int k) {
        long result = 0;
        int start = 0;
        int end = 0;
        HashMap<Character, Integer> vowelCount = new HashMap<>();
        int consonantCount = 0;

        int[] nextConsonant = new int[word.length()];
        int nextConsonantIndex = word.length();
        for (int i = word.length() - 1; i >= 0; i--) {
            nextConsonant[i] = nextConsonantIndex;
            if (!isVowel(word.charAt(i))) {
                nextConsonantIndex = i;
            }
        }

        while (end < word.length()) {
            char c = word.charAt(end);
            if (isVowel(c)) {
                vowelCount.put(c, vowelCount.getOrDefault(c, 0) + 1);
            } else {
                consonantCount++;
            }

            while (consonantCount > k) {
                char startChar = word.charAt(start);
                if (isVowel(startChar)) {
                    vowelCount.put(startChar, vowelCount.get(startChar) - 1);
                    if (vowelCount.get(startChar) == 0) {
                        vowelCount.remove(startChar);
                    }
                } else {
                    consonantCount--;
                }
                start++;
            }

            while (start < word.length() && vowelCount.size() == 5 && consonantCount == k) {
                result += nextConsonant[end] - end;
                char startChar = word.charAt(start);
                if (isVowel(startChar)) {
                    vowelCount.put(startChar, vowelCount.get(startChar) - 1);
                    if (vowelCount.get(startChar) == 0) {
                        vowelCount.remove(startChar);
                    }
                } else {
                    consonantCount--;
                }
                start++;
            }
            end++;
        }

        return result;
    }

    static boolean isVowel(char c) {
        return VOWELS.indexOf(c) >= 0;
    }
}
