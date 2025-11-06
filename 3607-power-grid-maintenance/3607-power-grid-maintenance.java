class Solution {
    static int c;
    static List<Integer>[] listArr;
    static Queue<Integer> queue;
    static boolean[] visited;
    static Map<Integer, Integer> map;
    static int setIdx;
    static List<Set<Integer>> setList;

    static final int CHECK = 1, OFFLINE = 2;

    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        this.c = c;
        visited = new boolean[c + 1];
        listArr = new ArrayList[c + 1];
        setList = new ArrayList<>();
        queue = new ArrayDeque<>();
        map = new HashMap<>();
        setIdx = 0;

        for (int i = 0; i <= c; i++) {
            listArr[i] = new ArrayList<>();
        }

        for (int[] con : connections) {
            listArr[con[0]].add(con[1]);
            listArr[con[1]].add(con[0]);
        }

        for (List<Integer> list : listArr) {
            Collections.sort(list);
        }

        init();

        List<Integer> answerList = new ArrayList<>();

        Arrays.fill(visited, false);

        out:
        for (int[] query : queries) {
            int target = query[1];

            if (query[0] == CHECK) {
                Integer idx = map.get(target);
                if (idx == null) {
                    answerList.add(-1);
                } else {
                    Set<Integer> tempSet = setList.get(idx);
                    if (tempSet.isEmpty()) {
                        answerList.add(-1);
                        continue;
                    }

                    if (!visited[target] && tempSet.contains(target)) {
                        answerList.add(target);
                        continue;
                    }

                    for (int i : tempSet) {
                        if (!visited[i]) {
                            answerList.add(i);
                            continue out;
                        }
                    }

                    answerList.add(-1);
                }
            } else if (query[0] == OFFLINE) {
                visited[target] = true;
                Integer idx = map.get(target);
                if (idx != null) {
                    setList.get(idx).remove(target);
                }
            }
        }

        int len = answerList.size();
        int[] answer = new int[len];
        for (int i = 0; i < len; i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }

    static void init() {
        for (int i = 1; i <= c; i++) {
            if (!visited[i]) {
                makeSet(i);
            }
        }
    }

    static void makeSet(int start) {
        queue.clear();
        visited[start] = true;
        queue.add(start);
        Set<Integer> set = new TreeSet<>();

        while (!queue.isEmpty()) {
            int now = queue.poll();
            set.add(now);
            map.put(now, setIdx);

            for (int next : listArr[now]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }

        setList.add(set);
        setIdx++;
    }
}
