// Time Complexity : O(n) // only to remove trimming white spaces, else o(1) for 10 digits in INT MAX
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    public int myAtoi(String s) {
        s = s.trim();
       if(s == null || s.length() == 0){
            return 0;
       } 
        char sign = '+';
       if(s.charAt(0) == '-'){
            sign = '-';
       }
       if(s.charAt(0) != '-' && s.charAt(0) != '+' && !Character.isDigit(s.charAt(0))){
        return 0;
       }

       int limit = Integer.MAX_VALUE/10;
       System.out.println(limit);
        int num =0;
       for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                if(sign == '+'){
                    if(num > limit || (num == limit && c >= '7')){
                        return Integer.MAX_VALUE;
                    }
                }
                else{
                    if(num > limit || (num == limit && c >= '8')){
                        return Integer.MIN_VALUE;
                    }
                }
                num = num * 10 + (c - '0'); 
            }
            else if (i != 0){
                break;
            }
       }
       if(sign == '-'){
            return -num;
        }
       return num;
    }
}