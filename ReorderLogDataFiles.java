//TC: O(NlogN)
//SC: O(1)
class Solution {
    public String[] reorderLogFiles(String[] logs) {

        if(logs == null || logs.length == 0) {
            return logs;
        }
        Arrays.sort(logs, (log1, log2) -> {
            String[] logs1 = log1.split(" ", 2);
            String[] logs2 = log2.split(" ", 2);

            boolean isDigit1 = Character.isDigit(logs1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(logs2[1].charAt(0));
            if(!isDigit1 && !isDigit2) {
                int c = logs1[1].compareTo(logs2[1]);
                if(c == 0) {
                    return logs1[0].compareTo(logs2[0]);
                }
                return c;
            }
            else if(isDigit1 && !isDigit2) {
                return 1;
            }
            else if(!isDigit1 && isDigit2) {
                return -1;
            }
            else {
                return 0;
            }
        });
        return logs;
    }
}