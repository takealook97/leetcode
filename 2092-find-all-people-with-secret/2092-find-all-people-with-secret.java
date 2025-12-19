class Solution {
    static Map<Integer, List<Meeting>> map;

    static class Meeting implements Comparable<Meeting> {
        int person, time;
        
        public Meeting(int person, int time) {
            this.person = person;
            this.time = time;
        }

        @Override
        public int compareTo(Meeting o) {
            return this.time - o.time;
        }

        @Override
        public String toString() {
            return "person = " + this.person + ", time = " + this.time;
        }
    }

    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        map = new HashMap<>();
        map.put(0, new ArrayList<>());
        map.get(0).add(new Meeting(firstPerson, 0));
        map.put(firstPerson, new ArrayList<>());
        map.get(firstPerson).add(new Meeting(0, 0));
        for (int[] meeting : meetings) {
            int x = meeting[0];
            int y = meeting[1];
            int t = meeting[2];

            if (map.get(x) == null) {
                map.put(x, new ArrayList<>());
            }
            map.get(x).add(new Meeting(y, t));

            if (map.get(y) == null) {
                map.put(y, new ArrayList<>());
            }
            map.get(y).add(new Meeting(x, t));
        }

        // for (int from : map.keySet()) {
        //     Collections.sort(map.get(from));
        //     System.out.println("from = " + from + " " + map.get(from));
        // }

        boolean[] visited = new boolean[n];
        Queue<Meeting> queue = new ArrayDeque<>();
        queue.add(new Meeting(0, 0));

        while (!queue.isEmpty()) {
            Meeting now = queue.poll();
            if (visited[now.person]) {
                continue;
            }
            visited[now.person] = true;

            for (Meeting next : map.get(now.person)) {
                if (now.time <= next.time) {
                    queue.add(next);
                }
            }
        }
        
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                answer.add(i);
            }
        }

        return answer;
    }
}