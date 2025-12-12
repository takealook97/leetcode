class Solution {
    static int len;
    static int[][] users;
    static final String MESSAGE = "MESSAGE", OFFLINE = "OFFLINE", ALL = "ALL", HERE = "HERE";
    static final int STATUS = 0, OFFLINE_END = 1, COUNT = 2, ON = 1, OFF = 0;

    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        len = numberOfUsers;
        users = new int[len][3];
        for (int[] user : users) {
            user[STATUS] = ON;
        }

        int n = events.size();
        int idx = 0;

        while (idx < n) {
            int timeStamp = Integer.parseInt(events.get(idx).get(1));

            for (int[] user : users) {
                if (user[STATUS] == OFF && user[OFFLINE_END] <= timeStamp) {
                    user[STATUS] = ON;
                    user[OFFLINE_END] = 0;
                }
            }

            int j = idx;
            while (j < n && Integer.parseInt(events.get(j).get(1)) == timeStamp) {
                j++;
            }

            for (int k = idx; k < j; k++) {
                List<String> list = events.get(k);
                if (list.get(0).equals(OFFLINE)) {
                    int id = Integer.parseInt(list.get(2));
                    int[] user = users[id];
                    user[STATUS] = OFF;
                    user[OFFLINE_END] = timeStamp + 60;
                }
            }

            for (int k = idx; k < j; k++) {
                List<String> list = events.get(k);
                if (list.get(0).equals(MESSAGE)) {
                    String mentionString = list.get(2);

                    if (mentionString.equals(ALL)) {
                        for (int[] user : users) {
                            user[COUNT]++;
                        }
                    } else if (mentionString.equals(HERE)) {
                        for (int[] user : users) {
                            if (user[STATUS] == ON) {
                                user[COUNT]++;
                            }
                        }
                    } else {
                        String[] mentions = mentionString.split(" ");
                        List<Integer> mentionList = getMentionList(mentions);
                        for (int id : mentionList) {
                            users[id][COUNT]++;
                        }
                    }
                }
            }

            idx = j;
        }

        int[] answer = new int[len];
        for (int i = 0; i < len; i++) {
            answer[i] = users[i][COUNT];
        }

        return answer;
    }

    static List<Integer> getMentionList(String[] mentions) {
        List<Integer> list = new ArrayList<>();
        for (String mention : mentions) {
            list.add(Integer.parseInt(mention.substring(2)));
        }
        return list;
    }
}
