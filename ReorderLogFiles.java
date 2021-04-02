// Time Complexity : The time complexity is O(nlogn) where n is the length of the array
// Space Complexity : Te space complexity is O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public String[] reorderLogFiles(String[] logs) {

        Arrays.sort(logs, (s1,s2) -> {

            String[] split1 = s1.split(" ",2);
            String[] split2 = s2.split(" ",2);

            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));

            //both of them are letter logs
            if(!isDigit1 && !isDigit2){
                int cmp = split1[1].compareTo(split2[1]);

                if(cmp == 0){
                    return split1[0].compareTo(split2[0]);
                }
                return cmp;
            }
            //letter log and digit log
            else if(isDigit1 && !isDigit2){
                return 1;
            }
            //letter log and digit log
            else if(!isDigit1 && isDigit2){
                return -1;
            }
            //both of them are digit logs
            else{
                return 0;
            }
        });
        return logs;
    }
}