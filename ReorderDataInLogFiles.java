//Time: O(NLogN) | Space: O(1)

class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (a, b) -> {
            String[] firstSecondHalf = a.split(" ", 2);
            String[] secondSecondHalf = b.split(" ", 2);
            boolean isDigit1 = Character.isDigit(firstSecondHalf[1].charAt(0));
            boolean isDigit2 = Character.isDigit(secondSecondHalf[1].charAt(0));
            if (!isDigit1 && !isDigit2) {
                int comp = firstSecondHalf[1].compareTo(secondSecondHalf[1]);
                if (comp == 0) {
                    return firstSecondHalf[0].compareTo(secondSecondHalf[0]);
                }
                return comp;
            } else if (isDigit1 && !isDigit2) {
                return 1;
            } else if (!isDigit1 && isDigit2) {
                return -1;
            } else {
                return 0;
            }
        });
        return logs;
    }
}