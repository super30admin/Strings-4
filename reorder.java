//TC: O(n log n * L): sort n logs with comparator; each compare scans up to L chars (content + id).
//SC: O(1)

//Split each log into id and content; classify by first char of content as letter-log or digit-log.
//Sort with comparator: letter-letter → compare content then id; letter vs digit → letter first; digit-digit → keep order (stable).
//Return the sorted array.

class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (a, b) -> {
            String[] splitArr1 = a.split(" ", 2);
            String[] splitArr2 = b.split(" ", 2);

            boolean isDigit1 = Character.isDigit(splitArr1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(splitArr2[1].charAt(0));

            if (!isDigit1 && !isDigit2) {
                int cmp = splitArr1[1].compareTo(splitArr2[1]);
                if (cmp == 0) {
                    return splitArr1[0].compareTo(splitArr2[0]);
                }
                return cmp;

            } else if (!isDigit1 && isDigit2) {
                return -1;     // letter-log before digit-log
            } else if (isDigit1 && !isDigit2) {
                return 1;      // digit-log after letter-log
            } else {
                return 0;      // both digit-logs → keep order (stable sort)
            }
        });
        return logs;
    }
}
