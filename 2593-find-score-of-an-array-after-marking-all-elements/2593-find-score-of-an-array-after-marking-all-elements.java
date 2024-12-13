class Solution {
    static int len;

    static class Info implements Comparable<Info> {
        int num, idx;

        public Info(int num, int idx) {
            this.num = num;
            this.idx = idx;
        }

        @Override
        public int compareTo(Info o) {
            if (this.num == o.num) {
                return this.idx - o.idx;
            }
            return this.num - o.num;
        }

    }
    public long findScore(int[] nums) {
        len = nums.length;
        PriorityQueue<Info> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[len];

        for (int idx = 0; idx < len; idx++) {
            pq.add(new Info(nums[idx], idx));
        }

        long answer = 0;
        while(!pq.isEmpty()) {
            Info info = pq.poll();
            if (visited[info.idx]) {
                continue;
            }

            visited[info.idx] = true;
            answer += info.num;
            if (info.idx + 1 < len) {
                visited[info.idx + 1] = true;
            }
            if (info.idx - 1 >= 0) {
                visited[info.idx - 1] = true;
            }
        }

        return answer;
    }
}
