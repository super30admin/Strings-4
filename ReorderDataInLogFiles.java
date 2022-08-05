// Time Complexity : O(NLogN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class ReorderDataInLogFiles {
    class Solution {
        public String[] reorderLogFiles(String[] logs) {

            Arrays.sort(logs, (a, b) -> {
                String[] strArr1 = a.split(" ", 2);
                String[] strArr2 = b.split(" ", 2);
                boolean isDigit1 = Character.isDigit(strArr1[1].charAt(0));
                boolean isDigit2 = Character.isDigit(strArr2[1].charAt(0));


                if(!isDigit1 && !isDigit2) {
                    int cmp = strArr1[1].compareTo(strArr2[1]);
                    if(cmp == 0) {
                        return strArr1[0].compareTo(strArr2[0]);
                    }
                    return cmp;
                } else if(!isDigit1 && isDigit2) {
                    return -1; // don't shuffle
                } else if(isDigit1 && !isDigit2) {
                    return 1; //shuffle
                } else{
                    return 0; // no change
                }
            });

            return logs;
        }
    }
}
