// Time Complexity : The time complexity is O(n) where n is the length of the string
// Space Complexity : Te space complexity is O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public int myAtoi(String s) {

        s = s.trim();

        if(s == null || s.length() == 0) return 0;

        int result = 0;
        char ch = s.charAt(0);
        //if the first character is a letter
        if(ch != '+' && ch != '-' && !Character.isDigit(ch)) return 0;

        char sign = '+';

        if(ch == '-'){
            sign = '-';
        }

        int limit = Integer.MAX_VALUE/10;

        for(int i=0;i<s.length();i++){

            ch = s.charAt(i);

            if(Character.isDigit(ch)){

                //if the number if positive
                if(sign == '+'){
                    //if the number goes out of limits
                    if(result > limit) return Integer.MAX_VALUE;
                    else if(result == limit && (ch - '0') >= 7) return Integer.MAX_VALUE;
                }
                //if the number is negative
                else if(sign == '-'){
                    //if the number goes out of limits
                    if(result > limit) return Integer.MIN_VALUE;
                    else if(result == limit && (ch - '0') >= 8) return Integer.MIN_VALUE;
                }
                result = result*10 + ch - '0';
            }
            else if(i != 0){
                break;
            }
        }

        if(sign == '+') return result;
        return -result;

    }
}