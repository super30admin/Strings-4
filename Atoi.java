// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
We first trim the input string. Later, we capture the sign which should be present at the first character.
Now, we parse the input string by each character, stop at non-digit and build the number. If the built number
is beyond 32 bit range, we clamp it to Integer.MAX or MIN value depending upon the sign we captured intially.
 */
class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        if(s.length() == 0)
            return 0;
        int result = 0;
        char ch = s.charAt(0);
        if(!Character.isDigit(ch) && ch != '+' && ch != '-')
            return 0;
        boolean flag = true;
        if(ch == '-')
            flag = false;
        int limit = Integer.MAX_VALUE / 10;
        for(int i = 0 ; i < s.length() ; i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                if(result > limit) {
                    if(flag)
                        return Integer.MAX_VALUE;
                    else
                        return Integer.MIN_VALUE;
                }
                else if(result == limit) {
                    if(flag) {
                        if(c >= '7')
                            return Integer.MAX_VALUE;
                    }
                    else {
                        if(c >= '8')
                            return Integer.MIN_VALUE;
                    }
                }
                result = result * 10 + c - '0';
            }
            else  {
                if(i != 0)
                    break;
            }
        }
        if(flag)
            return result;
        return -result;
    }
}