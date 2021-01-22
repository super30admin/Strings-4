package S30.Strings_4;

/*
Time Complexity : O(n)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/


public class aToI {

    public int myAtoi(String s) {
        s = s.trim();
        if(s.length() == 0) return 0;

        int result = 0;
        char firstCharacter = s.charAt(0);

        if(firstCharacter != '-' && firstCharacter != '+' && !Character.isDigit(firstCharacter)) return 0;

        char sign = firstCharacter == '-' ? '-' : '+';
        int limit = Integer.MAX_VALUE/10;

        for(int i = 0; i < s.length(); i++){

            char ch = s.charAt(i);

            if(Character.isDigit(ch)){

                if(sign == '+'){
                    if(result > limit || (result == limit && (ch - '0') > 7 )) return Integer.MAX_VALUE; // 2147483647
                }else{
                    if(result > limit || (result == limit && (ch - '0') > 8 )) return Integer.MIN_VALUE; // -2147483648
                }
                result = result * 10 + (ch - '0');
            }else if(i != 0){
                break;
            }
        }

        if(sign == '+') return result;
        return -1*result;
    }
}
