class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        boolean[][] arr = new boolean[numCourses][numCourses];

        for (int[] p : prerequisites) {
            arr[p[0]][p[1]] = true;
        }

        for (int k = 0; k < numCourses; k++) {
            for (int i = 0; i < numCourses; i++) {
                for (int j = 0; j < numCourses; j++) {
                    arr[i][j] |= arr[i][k] && arr[k][j];
                }
            }
        }

        List<Boolean> answer = new ArrayList<>();
        for (int[] query : queries) {
            answer.add(arr[query[0]][query[1]]);
        }

        return answer;
    }
}
