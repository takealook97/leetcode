import java.util.*;

class Solution {
    static String expression;
    static int lim, nextIdx = 0;

    static final char TRUE = 't', FALSE = 'f', DELIMITER = ',', 
        OPEN = '(', CLOSE = ')', AND = '&', OR = '|', NOT = '!';
    static final int NONE = -1, ALL_FALSE = 0, ALL_TRUE = 1, MIXED = 2;

    public boolean parseBoolExpr(String expression) {
        this.expression = expression;
        lim = expression.length();

        return findGroup(-1, 0) == 1;
    }
    
    static int findGroup(int status, int idx) {
        if(idx >= lim) {
            return status;
        }

        char cur = expression.charAt(idx);

        if(cur == DELIMITER) {
            return findGroup(status, idx + 1);
        } else if(cur == OPEN) {
            status = findGroup(status, idx + 1);
            return status;

        } else if(cur == CLOSE) {
            nextIdx = idx + 1;
            return status;
        } else if(cur == TRUE) {
            if (status == NONE || status == ALL_TRUE) {
                return findGroup(ALL_TRUE, idx + 1);
            }
            return findGroup(MIXED, idx + 1);
        } else if(cur == FALSE) {
            if (status == NONE || status == ALL_FALSE) {
                return findGroup(ALL_FALSE, idx + 1);
            }
            return findGroup(MIXED, idx + 1);
        } else if(cur == AND) {
            if(status == NONE) {
                status = findGroup(status, idx + 1);
            }

            if(status == ALL_FALSE || status == MIXED) {
                return findGroup(ALL_FALSE, nextIdx);
            }

            return findGroup(ALL_TRUE, nextIdx);
        } else if(cur == OR) {
            if(status == NONE) {
                status = findGroup(status, idx + 1);
            }

            if(status == ALL_TRUE || status == MIXED) {
                return findGroup(ALL_TRUE, nextIdx);
            }

            return findGroup(ALL_FALSE, nextIdx);
        } else { // NOT
            if(status == NONE) {
                status = findGroup(status, idx + 1);
            }

            if(status == ALL_TRUE) {
                return findGroup(ALL_FALSE, nextIdx);
            } else if(status == ALL_FALSE) {
                return findGroup(ALL_TRUE, nextIdx);
            }

            return findGroup(MIXED, nextIdx);
        }
    }
}
