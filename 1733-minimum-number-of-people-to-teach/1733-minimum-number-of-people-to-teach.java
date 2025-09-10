class Solution {
    static int n;
    static int[][] languages;
    static int[][] friendships;

    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        this.n = n;
        for (int[] language : languages) {
            Arrays.sort(language);
        }
        this.languages = languages;
        this.friendships = friendships;

        Set<Integer> set = new HashSet<>();
        for (int[] friendship : friendships) {
            int from = friendship[0];
            int to = friendship[1];
            if (!isPossible(from, to)) {
                set.add(from);
                set.add(to);
            }
        }

        if (set.isEmpty()) {
            return 0;
        }

        int answer = Integer.MAX_VALUE;

        for (int lan = 1; lan <= n; lan++) {
            int need = 0;
            for (int person : set) {
                if (!knowsLanguage(person, lan)) {
                    need++;
                }
            }
            answer = Math.min(answer, need);
        }

        return answer;
    }

    static boolean isPossible(int from, int to) {
        for (int i : languages[from - 1]) {
            for (int j : languages[to - 1]) {
                if (i == j) {
                    return true;
                }
            }
        }

        return false;
    }

    static boolean knowsLanguage(int person, int lan) {
        for (int l : languages[person - 1]) {
            if (l == lan) {
                return true;
            }
        }
        return false;
    }
}
