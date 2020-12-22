// Time Complexity : O(n), n is length of given string
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes

// Your code here along with comments explaining your approach
//skip spaces, parse 1st + or - as sign, then if we encounter alphabets, invalid string, else only parse numbers
//build the number as num = num*10 + charAt(i)-'0', for the case of exceeding Integer bounds, check for Integer.MAX_VALUE/10 before adding next digit

class Solution {
    public int myAtoi(String s) {
        if(s==null || s.length()==0)
            return 0;
        
        int i = 0;
        int sign = 1;
        int num = 0;
        
        while(i<s.length() && s.charAt(i)==' '){
            i++;
        }
        
        if(i<s.length() && (s.charAt(i)=='+' || s.charAt(i)=='-')){
            sign = s.charAt(i)=='+' ? 1 : -1;
            i++;
        }
        
        while(i<s.length() && Character.isDigit(s.charAt(i))){
            if(num>Integer.MAX_VALUE/10 || (num==Integer.MAX_VALUE/10 && s.charAt(i)-'0'>Integer.MAX_VALUE%10)){
                return sign==1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            
            num = num*10 + s.charAt(i)-'0';
            i++;
        }
        
        return sign*num;
    }
}