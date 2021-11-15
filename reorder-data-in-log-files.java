//TC:O(n log n)
//SC: O(1)
//running on leetcode: yes
class Solution {
    public String[] reorderLogFiles(String[] logs) {
        if(logs == null || logs.length == 0) return logs;
        Arrays.sort(logs, (l1, l2) -> {
            String[] log1 = l1.split(" ", 2);
            String[] log2 = l2.split(" ", 2);
            boolean isDigit1 = Character.isDigit(log1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(log2[1].charAt(0));
            if(!isDigit1 && !isDigit2) {
                int cmp = log1[1].compareTo(log2[1]);
                if(cmp == 0) {
                    return log1[0].compareTo(log2[0]);
                }
                return cmp;
            }
            else if(!isDigit1 && isDigit2) {
                return -1;
            }
            else if(isDigit1 && !isDigit2) {
                return 1;
            }
            else {
                return 0;
            }
        });
        return logs;
    }
}
