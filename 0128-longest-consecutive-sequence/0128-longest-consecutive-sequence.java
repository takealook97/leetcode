class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        ArrayList<Integer> list = new ArrayList<>(set);
        int N = list.size();
        if (N <= 1) {
            return N;
        }

        Collections.sort(list);
        int answer = 0;
        int len = 1;
        for (int i = 0; i < N - 1; i++) {
            if (list.get(i + 1) - list.get(i) == 1) {
                len++;
            } else {
                answer = Math.max(answer, len);
                len = 1;
            }
        }
        answer = Math.max(answer, len);

        return answer;
    }
}
