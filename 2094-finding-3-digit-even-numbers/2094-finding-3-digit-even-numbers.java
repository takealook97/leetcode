class Solution {
    static int len;
    static int[] digits;
    static boolean[] visited;
    static Set<Integer> set;

    public int[] findEvenNumbers(int[] digits) {
        len = digits.length;
        this.digits = digits;
        visited = new boolean[len];
        set = new HashSet<>();

        find(0, 0);

        int size = set.size();
        int[] answer = new int[size];
        int idx = 0;
        for (int num : set) {
            answer[idx++] = num;
        }
        Arrays.sort(answer);

        return answer;
    }

    static void find(int num, int depth) {
        if (depth >= 3) {
            if (num % 2 == 0) {
                set.add(num);
            }
            return;
        }

        for (int i = 0; i < len; i++) {
            if (depth == 0 && digits[i] == 0) {
                continue;
            }

            if (!visited[i]) {
                visited[i] = true;
                find(num * 10 + digits[i], depth + 1);
                visited[i] = false;
            }
        }
    }
}
