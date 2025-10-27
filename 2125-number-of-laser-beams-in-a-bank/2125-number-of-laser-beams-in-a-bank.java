class Solution {
    public int numberOfBeams(String[] bank) {
        List<Integer> list = new ArrayList<>();
        int len = bank[0].length();
        for (String s : bank) {
            int count = 0;
            for (int i = 0; i < len; i++) {
                if (s.charAt(i) == '1') {
                    count++;
                }
            }

            if (count > 0) {
                list.add(count);
            }
        }

        if (list.size() <= 1) {
            return 0;
        }

        int answer = 0;
        int size = list.size();
        for (int i = 0; i < size - 1; i++) {
            answer += (list.get(i) * list.get(i + 1));
        }

        return answer;
    }
}
