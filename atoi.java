//TC - O(L)
//SC - O(1)
class Solution {
    public int myAtoi(String str) {
        int index = 0;
        int total = 0;
        int sign = 1;
        int len = str.length();
        int maxval = Integer.MAX_VALUE;
        int minval = Integer.MIN_VALUE;
        // Check if empty string
        if(str.length() == 0)
            return 0;
        
        // remove white spaces from the string
        while(index < len && str.charAt(index) == ' ')
            index++;
        
        if (index == len) return 0;
        
        // get the sign
        if(str.charAt(index) == '+' || str.charAt(index) == '-') {
            sign = str.charAt(index) == '+' ? 1 : -1;
            index++;
        }
        
        
        while(index < str.length()) {
            int digit = str.charAt(index) - '0';
            if(digit < 0 || digit > 9) break;
            
            // check for overflow
            if( maxval/ 10 < total || maxval / 10 == total && maxval % 10 < digit)
                return sign == 1 ? maxval : minval;
            
            total = total*10 + digit;
            index++; 
        }
        return total*sign;
    }
}
