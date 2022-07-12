/*
Problem: https://leetcode.com/problems/string-to-integer-atoi/
TC: O(n)
SC: O(1)
*/
class Solution {
    public int myAtoi(String s) {
                
        // Remove whitespaces
        s = s.trim();
        
        if (s == null || s.length() == 0)
            return 0;
        
        // Check first character for sign
        char first = s.charAt(0);
        char sign = '+';
        
        if (!(first == '+' || first == '-') && !Character.isDigit(first))
            return 0;
        
        if (first == '-')
            sign = '-';
        
        // integer limit on positive side is 2,147,483,647 and on negative side is -2,147,483,648.
        // We will set our limit to 2,147,483,64 to prevent overflow.
        // So if the last digit on the positive side is greater than 7, we return max value
        // and if the last digit on the negative side is greater than 8, we return min value
        int limit = Integer.MAX_VALUE / 10;
        int result = 0;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                if (sign == '+') {
                    // For numbers greater than limit, return MAX_VALUE
                   
                    if (result > limit) return Integer.MAX_VALUE;
                    if (result == limit) {
                        if (c - '0' > 7) return Integer.MAX_VALUE;
                    }
                } else {
                    // For numbers greater than limit, return MAX_VALUE
                    if (result > limit) return Integer.MIN_VALUE;
                    if (result == limit) {
                        if (c - '0' > 8) return Integer.MIN_VALUE;
                    }
                }
                result = result * 10 + c - '0';
            } else if (i != 0 && !Character.isDigit(c)) {
                break;
            }
        }
        
        if (sign == '-')
            return -result;
        return result;
    }
}