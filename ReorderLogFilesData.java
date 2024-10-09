// Time Complexity: O(n logn)
// Space Complexity: O(1)

import java.util.Arrays;

class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (a, b) -> {
            String[] strArr1 = a.split(" ", 2);
            String[] strArr2 = b.split(" ", 2);

            boolean isDigit1 = Character.isDigit(strArr1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(strArr2[1].charAt(0));

            if (!isDigit1 && !isDigit2) {
                int comp = strArr1[1].compareTo(strArr2[1]);
                if (comp == 0)
                    return strArr1[0].compareTo(strArr2[0]);
                return comp;
            } else if (!isDigit1 && isDigit2)
                return -1;
            else if (isDigit1 && !isDigit2)
                return 1;
            else {
                return 0;
            }
        });

        return logs;
    }
}