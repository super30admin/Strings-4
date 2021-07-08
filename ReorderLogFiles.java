// Time Complexity : O(n) where n is the length of the string
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
/* Your code here along with comments explaining your approach: Sort the array and split the string into string array 1 and into string array 2.
Split it into two parts, where first part will be redundant part and second part will be the comparison between digits and letters. If one is a 
digit and other one is not a digit return 1 or -1 accordingly.
*/
class Solution {
    public String[] reorderLogFiles(String[] logs) {
        if(logs == null || logs.length  == 0) return logs;
        Arrays.sort(logs, (s1,s2) -> {
            String[] strArr1 = s1.split(" ", 2);                                                // Split it into two indices
            String[] strArr2 = s2.split(" ", 2);
            boolean digit1 = Character.isDigit(strArr1[1].charAt(0));                                           // Get the digit if it is a digit
            boolean digit2 = Character.isDigit(strArr2[1].charAt(0));
            if(!digit1 && !digit2){                                                                         // Both are not digits
                if(strArr1[1].compareTo(strArr2[1]) == 0){                                                  // It comes to lexicographic comparison of letters
                    return (strArr1[0].compareTo(strArr2[0]));
                } else {
                return (strArr1[1].compareTo(strArr2[1]));                                                  // Return the result of comparison
                } 
            } else if(digit1 && !digit2){                                                                       // Either one is digit
                return 1;    
            }   
            else if(!digit1 && digit2){                                                                     // Either one is digit
                return -1;
            } else {
                return 0;                                                                                       // Both are digits, no comparison needed
            }
        }); 
        
        return logs;
    }
}