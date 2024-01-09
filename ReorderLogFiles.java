// Time Complexity : O(nlogn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class ReorderLogFiles {
    class Solution {
        public String[] reorderLogFiles(String[] logs) {
        /*Custom sort
        split array int 2 parts
        check isDigit */

        /*[1, 2, 0, 3]
        Arrays.sort : - means 1st will be in front(0-3)
        + means 2nd in front(2-0)*/

            Arrays.sort(logs, (a, b) -> {
                //split into 2 parts after first " "
                String[] strArr1 = a.split(" ", 2);
                String[] strArr2 = b.split(" ", 2);

                boolean isDigit1 = Character.isDigit(strArr1[1].charAt(0));
                boolean isDigit2 = Character.isDigit(strArr2[1].charAt(0));

                if(!isDigit1 && !isDigit2){
                    //both are letter
                    int comp = strArr1[1].compareTo(strArr2[1]);
                    //-1, 0, 1
                    if(comp == 0){
                        //lexi sort first ele
                        return strArr1[0].compareTo(strArr2[0]);
                    }
                    return comp;
                }
                else if(isDigit1 && !isDigit2){
                    //2nd is letter and 1st is digit
                    return 1;
                }
                else if(!isDigit1 && isDigit2){
                    //first is letter and 2nd is digit
                    return -1;
                }
                else{
                    //both digit
                    return 0;
                }
            });
            return logs;
        }
    }
}
