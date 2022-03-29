// Time Complexity = O(n), since we are trimming the string, if there were no leading or trailing spaces we can
// say the TC is constant since we wont exceed Integer.MAX_VALUE
// Space Complexity = O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class Solution {
    public int myAtoi(String s) {
        if (s==null) return 0;
        s = s.trim();
        if (s.length() == 0) return 0;

        char sign = '+';
        char first = s.charAt(0);
        if (first == '-') sign = '-';

        if (first != '+' && sign != '-' && !Character.isDigit(first)) return 0;

        int limit = Integer.MAX_VALUE/10;
        int result = 0;

        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                if (sign == '+') {
                    if (result > limit) {
                        return Integer.MAX_VALUE;
                    }
                    else if (result == limit) {
                        if (c-'0' > 7) {
                            return Integer.MAX_VALUE;
                        }
                    }
                }
                else {
                    if (result > limit) {
                        return Integer.MIN_VALUE;
                    }
                    else if (result == limit) {
                        if (c-'0' > 8) {
                            return Integer.MIN_VALUE;
                        }
                    }
                }
                result = result*10+(c-'0');
            }
            else if (i != 0) {
                break;
            }
        }

        if (sign == '-') return -result;
        return result;
    }
}