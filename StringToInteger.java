// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

public class StringToInteger {

    public int myAtoi(String s) {
        if( s == null) return 0;

        //remove white spaces
        s = s.trim();
        if(s.length() == 0) return 0;

        char firstChar = s.charAt(0);

        if( (firstChar != '+' && firstChar != '-') && !Character.isDigit(firstChar)) return 0;

        int result = 0;
        char sign = '+';
        if(firstChar == '-')
            sign = '-';

        int limit = Integer.MAX_VALUE/10;

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if(Character.isDigit(c)){
                int digit = c - '0';

                if(sign == '+'){

                    if(result > limit) return Integer.MAX_VALUE;
                    if(result == limit){
                        if(digit > 7) return Integer.MAX_VALUE;
                    }
                }else{
                    if(result > limit) return Integer.MIN_VALUE;
                    if(result == limit){
                        if(digit > 8) return Integer.MIN_VALUE;
                    }
                }
                result = result*10 + digit;
            }else if(i != 0){
                break;
            }
        }

        if(sign == '-') return -result;
        return result;
    }
}
