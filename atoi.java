// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int myAtoi(String s) {
    
        int result = 0;
        int limit = Integer.MAX_VALUE / 10;
        int remainder = Integer.MAX_VALUE % 10;
        
        s = s.trim();
    
        if(s == null || s.length() == 0) {
            return 0;
        }
        
        if(!(s.charAt(0) == '-' || s.charAt(0) =='+') && !Character.isDigit(s.charAt(0))) {
            return result;
        }
                
        int sign = s.charAt(0) == '-' ? -1 : 1;
        
        for(int i = 0; i < s.length(); i++) {
            
            char ch = s.charAt(i);
            
            if(i != 0 && !Character.isDigit(ch)) {
                return sign* result;
            }
            
            if(i == 0 && (ch == '-' || ch =='+')) {
                continue;
            }
            
            if(result > limit) {
                return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            
            if(result == limit && ch -'0' > remainder) {
                return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            
            result = (result * 10) + ch - '0';
                        
        }
        
        return sign * result;
        
    }
}