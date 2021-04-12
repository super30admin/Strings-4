//TC: O(N) 
//SC: O(1)
//Did it run successfully on Leetcode?:Yes
class Solution {
    public int myAtoi(String str) {
       if (str == null || str.length() == 0)
           return 0;
       int i = 0;
       int sign = 1; //positive (+)
       int result = 0;
       while ( i < str.length() && str.charAt(i) == ' '){
           i++;
       }
       if (i < str.length() && ((str.charAt(i) == '+') || (str.charAt(i) == '-'))){
           sign = (str.charAt(i) == '+') ? 1 : -1;
           i++;
       }
       while (i < str.length() && Character.isDigit(str.charAt(i))){
          char c = str.charAt(i);
          if ( result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE/10 && c-'0' > Integer.MAX_VALUE % 10 ))
          {
              return sign == 1? Integer.MAX_VALUE : Integer.MIN_VALUE;
          } 
              
          result = result * 10 + str.charAt(i) - '0';
          i++;
       } 
      return result * sign;
    }
}
