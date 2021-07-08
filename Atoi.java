// Time Complexity : O(n) where n is the length of the string
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
/* Your code here along with comments explaining your approach: This has a lot of edge cases to cover. Go through the characters one by one, if the
character is a dot or is a letter at the initial stage, return 0 else if the character is a number, check if it is the max value of integer or greater
than the digit, then return the integer max value and min value. If the number is not a digit, return a 0.  If the sign is minus, return the - result
else return the + result.
*/
class Solution {
    public int myAtoi(String str) {
        str = str.trim();
        if(str == null || str.length() == 0) return 0;
        int i = 0;
        if(str.charAt(i) == '.' || Character.isLetter(str.charAt(i))) return 0;                         // if the first character is not a digit
        char sign = (str.charAt(i) == '-') ? '-' : '+';                                     // Check the sign
        int number = 0;
        int maxLimit = Integer.MAX_VALUE/10;
        while(i < str.length()){
            char c = str.charAt(i);
            if(Character.isDigit(c)){
                if(c >= '0' && c <= '9'){                                                                           // If it is a number
                    int val = c - '0';                                                                          // get the digit
                    if(sign == '+'){
                        if(number > maxLimit){                                                                  // If te number > max limit
                            return Integer.MAX_VALUE;
                        } else if(number == maxLimit){
                            if(val > 7) return Integer.MAX_VALUE;                                           // If the value digit is > 7
                        }
                    } else if(sign == '-'){                                                                 // If the sign is negative
                        if(number > maxLimit){
                            return Integer.MIN_VALUE;                                                       // Check it can be min value
                        } else if(number == maxLimit){
                            if(val > 8) return Integer.MIN_VALUE;                                       // If the digit is > 8
                        }
                    }
                 number = number * 10 + val;                                                                // Form the number
                }
            } else { if(i != 0) 
                break;                                                                                      // It is not a digit anymore
            }
            i++;
        }
        if(sign == '-') return -number;                                                                             // It is negative number
        return number;
    }
}