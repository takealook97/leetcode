class Solution {
    static final Set<Character> VOWELS = Set.of('a','e','i','o','u','A','E','I','O','U');


    public String sortVowels(String s) {
        int vowelCount = 0;
        for (char c : s.toCharArray()) {
            if (VOWELS.contains(c)) {
                vowelCount++;
            }
        }

        char[] arr = new char[vowelCount];
        int idx = 0;
        for (char c : s.toCharArray()) {
            if (VOWELS.contains(c)) {
                arr[idx++] = c;
            }
        }

        idx = 0;
        Arrays.sort(arr);

        int len = s.length();
        char[] result = new char[len];
        int i = 0;

        for (char c : s.toCharArray()) {
            if (VOWELS.contains(c)) {
                result[i++] = arr[idx++];
            } else {
                result[i++] = c;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : result) {
            sb.append(c);
        }

        return sb.toString();
    }
}