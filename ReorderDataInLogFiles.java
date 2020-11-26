// Time Complexity : O(nxmlogn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
// Creating a comparator
class Solution {
    public String[] reorderLogFiles(String[] logs) {
        if(logs==null || logs.length==0)
            return null;
        
        Arrays.sort(logs, (log1, log2) -> {
            
            String[] str1 = log1.split(" ");
            String[] str2 = log2.split(" ");
            
            String idStr1 = str1[0];
            String idStr2 = str2[0];
            
            char c1 = str1[1].charAt(0);
            char c2 = str2[1].charAt(0);
            
            if(Character.isDigit(c1) && Character.isDigit(c2)){
                return 0;
            }
            
            if(Character.isLetter(c1) && Character.isDigit(c2)){
                return -1;
            }
            
            if(Character.isDigit(c1) && Character.isLetter(c2)){
                return 1;
            }
            
            String value1 = log1.substring(log1.indexOf(" ") + 1);
            String value2 = log2.substring(log2.indexOf(" ") + 1);
            
            if(value1.equals(value2)){
                return idStr1.compareTo(idStr2);
            }
            
            return value1.compareTo(value2); 
        });
        
        return logs;   
    }
}