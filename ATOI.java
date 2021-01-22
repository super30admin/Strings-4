// Time Complexity : O(n) --> where n is the length of input string
// Space Complexity : O(1)
// Did this code successfully run on Leetcode (8): Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public int myAtoi(String str) {
        str = str.trim();
        
        // edge case
        if (str.length() == 0) return 0;
        char first = str.charAt(0);
        if (!Character.isDigit(first) && first != '+' && first != '-') return 0;
        
        char sign = first == '-' ? '-' : '+';
        int result = 0; int maxLimit = Integer.MAX_VALUE / 10;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isDigit(c)) {
                // if breaching the limits
                if (sign == '+') {
                    if (result > maxLimit) return Integer.MAX_VALUE;
                    else if (result == maxLimit) {
                        if (c - '0' > 7) return Integer.MAX_VALUE;
                    }
                }
                else {
                    if (result > maxLimit) return Integer.MIN_VALUE;
                    else if (result == maxLimit) {
                        if (c - '0' > 8) return Integer.MIN_VALUE ;
                    }
                }
                
                // if not breaching the limits
                result = result * 10 + c - '0';
            }
            else if (i != 0) break;
        }
        
        if (sign == '-') return -result;
        return result;
    }
}