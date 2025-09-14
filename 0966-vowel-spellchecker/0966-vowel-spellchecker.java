class Solution {
    static final String EMPTY = "";
    static final Set<Character> vowels = Set.of('a','e','i','o','u');

    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> exact = new HashSet<>();
        Map<String, String> capMap = new HashMap<>();
        Map<String, String> vowelMap = new HashMap<>();

        for (String word : wordlist) {
            exact.add(word);

            String lower = word.toLowerCase();
            capMap.putIfAbsent(lower, word);

            String dev = devowel(lower);
            vowelMap.putIfAbsent(dev, word);
        }

        String[] answer = new String[queries.length];
        int idx = 0;

        for (String q : queries) {
            if (exact.contains(q)) {
                answer[idx++] = q;
                continue;
            }

            String lower = q.toLowerCase();
            if (capMap.containsKey(lower)) {
                answer[idx++] = capMap.get(lower);
                continue;
            }

            String dev = devowel(lower);
            if (vowelMap.containsKey(dev)) {
                answer[idx++] = vowelMap.get(dev);
                continue;
            }

            answer[idx++] = EMPTY;
        }

        return answer;
    }

    static String devowel(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (vowels.contains(c)) sb.append('*');
            else sb.append(c);
        }
        return sb.toString();
    }
}
