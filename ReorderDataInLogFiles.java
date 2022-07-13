// Time Complexity : O(nlogn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


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
                int cmp = logs1[1].compareTo(logs2[1]);
                
                if(cmp == 0) {
                    return logs1[0].compareTo(logs2[0]);
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