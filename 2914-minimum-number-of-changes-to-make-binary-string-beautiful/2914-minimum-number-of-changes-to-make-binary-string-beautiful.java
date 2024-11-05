class Solution {
    static int len, count;
    static ArrayList<Integer> list;
    static int answer;

    public int minChanges(String s) {
        len = s.length();
        answer = 0;
        setList(s);
        search();
        
        return answer;

    }

    static void setList(String s) {
        list = new ArrayList<>();
        int count = 1;

        for (int i = 0; i < len - 1; i++) {
            if(s.charAt(i) == s.charAt(i + 1)) {
                count++;
            } else {
                list.add(count);
                count = 1;
            }
        }

        list.add(count);
    }

    static void search() {
        int size = list.size();
        count = 0;
        int num;
        boolean isAdded = false;
        for (int i = 0; i < size; i++) {
            num = list.get(i);
            if(isAdded) {
                num++;
                isAdded = false;
            }

            if (num % 2 == 1) {
                isAdded = true;
                answer++;
            }
        }
    }
}
