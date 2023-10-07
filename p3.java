// Time Complexity : O(nlogn) 
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach

class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (a, b) -> {
            String[] fir = a.split(" ", 2);
            String[] sec = b.split(" ", 2);

            Boolean isDigit1 = Character.isDigit(fir[1].charAt(0));
            Boolean isDigit2 = Character.isDigit(sec[1].charAt(0));

            if(!isDigit1 && !isDigit2){
                int isLarge = fir[1].compareTo(sec[1]);
                if(isLarge == 0){
                    return fir[0].compareTo(sec[0]);
                }
                else return isLarge;
            }
            else{
                return isDigit1 ? (isDigit2 ? 0:1):-1;
            }
        });
        return logs;
    }
}