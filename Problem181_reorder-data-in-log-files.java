// Time Complexity: O(M⋅N⋅logN)
// Space Complexity: O(M⋅logN)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (str1, str2) -> {
            String[] strArr1 = str1.split(" ", 2);
            String[] strArr2 = str2.split(" ", 2);
            // second part if digit or is it a letter
            boolean isDigit1 = Character.isDigit(strArr1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(strArr2[1].charAt(0));
            if(!isDigit1 && !isDigit2) {
                // both are letters
                int comp = strArr1[1].compareTo(strArr2[1]);
                if(comp == 0) {
                    return strArr1[0].compareTo(strArr2[0]);
                }
                return comp;
            } else if(!isDigit1 && isDigit2) {
                return -1;
            } else if(isDigit1 && !isDigit2) {
                return 1;
            } else {
                return 0;
            }
        });
        return logs;
    }
}