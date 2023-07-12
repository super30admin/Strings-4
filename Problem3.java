import java.util.Arrays;

class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (a, b) -> {
            String[] splitA = a.split(" ", 2);
            String[] splitB = b.split(" ", 2);
            
            boolean isDigit1 = Character.isDigit(splitA[1].charAt(0));
            boolean isDigit2 = Character.isDigit(splitB[1].charAt(0));
            
            if (!isDigit1 && !isDigit2) {
                int cmp = splitA[1].compareTo(splitB[1]);
                if (cmp != 0) {
                    return cmp;
                }
                return splitA[0].compareTo(splitB[0]);
            } else if (isDigit1 && !isDigit2) {
                return 1; // 'a' is a digit log, 'b' is a letter log
            } else if (!isDigit1 && isDigit2) {
                return -1; // 'a' is a letter log, 'b' is a digit log
            } else {
                return 0; // both logs are digit logs
            }
        });
        return logs;
    }
}
