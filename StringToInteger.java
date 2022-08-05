// Time Complexity : O(N), because of trim() in worst case otherwise O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class StringToInteger {
    class Solution {
        public int myAtoi(String s) {
            if(s == null || s.length() == 0 || s.trim().length() == 0) return 0;
            s = s.trim();
            boolean isPositive = true;
            char firstChar = s.charAt(0);
            if(firstChar == '-')
                isPositive = false;
            if(firstChar != '-' && firstChar != '+' && !Character.isDigit(firstChar))
                return 0;
            int result = 0;
            int limit = Integer.MAX_VALUE / 10;
            for(int i=0; i<s.length(); i++) {
                char c = s.charAt(i);
                if(Character.isDigit(c)) {
                    if(result > limit) {
                        if(isPositive) return Integer.MAX_VALUE;
                        else return Integer.MIN_VALUE;
                    } else if (result == limit){
                        if(isPositive) {
                            if(c - '0' >=7) return Integer.MAX_VALUE;
                        } else {
                            if(c-'0' >=8) return Integer.MIN_VALUE;
                        }
                    }
                    result = result * 10 + (s.charAt(i) - '0');
                } else if( i != 0){
                    break;
                }
            }
            if(!isPositive) return -result;
            return result;
        }
    }
}
