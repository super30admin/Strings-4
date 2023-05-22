// Approach:
// 1. Split logs in 2 parts
// 2. check if they are digit log or letter log
// 3. If both are letter logs, further sort lexicographically, if again same, sort using identifiers.
// Time: O(mn*logn)
// Space: O(m*logn)

import java.util.Arrays;

class ReorderDataInLogFiles {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (str1, str2) -> {
            String[] strArr1 = str1.split(" ", 2);  // splits in 2: [let2, own kit dig]
            String[] strArr2 = str2.split(" ", 2);
            boolean isDigit1 = Character.isDigit(strArr1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(strArr2[1].charAt(0));

            if (!isDigit1 && !isDigit2) {
                // both are letter logs
                int comp = strArr1[1].compareTo(strArr2[1]);    // +ve 0 -ve
                if (comp == 0) {
                    return strArr1[0].compareTo(strArr2[0]);
                }
                return comp;
            } else if (!isDigit1 && isDigit2) {
                // -ve number makes sure first one is before second one
                return -6;
            } else if (isDigit1 && !isDigit2) {
                // +ve number makes sure second one is before first one
                return 11;
            } else {
                return 0;   // no change
            }
        });
        return logs;
    }
}