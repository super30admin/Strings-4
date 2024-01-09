// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class ATOI {
    class Solution {
        public int myAtoi(String s) {
            int sLen = s.length();
            int result = 0;

            if(sLen == 0 || s == null)
                return result;

            int idx = 0;

            //remove all white spaces
            while(idx < sLen && s.charAt(idx) == ' '){
                idx++;
            }

            boolean isNegative = false;
            //check sign
            if(idx < sLen && s.charAt(idx) == '-'){
                isNegative = true;
                idx++;
            }
            else if(idx < sLen && s.charAt(idx) == '+'){
                idx++;
            }


            //accumulate  digit
            int digit = 0;

            while(idx < sLen && Character.isDigit(s.charAt(idx))){
                digit = s.charAt(idx)- '0';
                //check Int overflow
                if((result > Integer.MAX_VALUE / 10) || (result == Integer.MAX_VALUE / 10 && digit > 7)){
                    return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }

                result = (result * 10) + digit;
                idx++;
            }

            return isNegative ? -result : result;
        }
    }
}
