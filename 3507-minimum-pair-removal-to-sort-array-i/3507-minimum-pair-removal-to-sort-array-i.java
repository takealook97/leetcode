class Solution {
    static int len;
    static List<Integer> list;

    public int minimumPairRemoval(int[] nums) {
        len = nums.length;
        list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }

        int answer = 0;
        while (!isIncreasing()) {
            make();
            answer++;
        }

        return answer;
    }

    static void make() {
        int size = list.size();
        int min = Integer.MAX_VALUE;
        int idx = -1;
        for (int i = 0; i < size - 1; i++) {
            int sum = list.get(i) + list.get(i + 1);
            if (sum < min) {
                min = sum;
                idx = i;
            }
        }

        list.set(idx, min);
        list.remove(idx + 1);
    }

    static boolean isIncreasing() {
        int cur = list.get(0);
        for (int num : list) {
            if (cur <= num) {
                cur = num;
                continue;
            } else {
                return false;
            }
        }

        return true;
    }
}

