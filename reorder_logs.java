// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    public String[] reorderLogFiles(String[] logs) {
        if(logs == null || logs.length == 0){
            return logs;
        }

        Arrays.sort(logs, (log1,log2) -> {
            String [] strArr1 = log1.split(" ", 2);
            String [] strArr2 = log2.split(" ", 2);
            
            boolean isDigit1 = Character.isDigit(strArr1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(strArr2[1].charAt(0));

            if(!isDigit1 && !isDigit2){
                int cmp = strArr1[1].compareTo(strArr2[1]);
                if(cmp == 0){
                    return strArr1[0].compareTo(strArr2[0]);
                }
                return cmp;
            }
            else if(!isDigit1 && isDigit2){
               return 1;
            }
            else if(isDigit1 && !isDigit2){
               return -1;
            }
            else{
                return 0;
            }
        });

        return logs;
    }
}
