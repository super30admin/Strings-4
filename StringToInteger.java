// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

public class StringToInteger {
    public int myAtoi(String s) {
        int result = 0;
        s = s.trim();
        if(s == null || s.length()==0) return result;
        char c = s.charAt(0);
        if(!Character.isDigit(c) && !(c == '+' || c=='-')){
            return result;
        }
        boolean flag = false;
        int limit = Integer.MAX_VALUE/10;
        if( c== '-') flag = true;
        for(int i=0; i<s.length(); i++){
            c = s.charAt(i);
            if(Character.isDigit(c)){
                if(result > limit){
                    if(!flag)  return Integer.MAX_VALUE;
                    else return Integer.MIN_VALUE;
                }else if(result == limit){

                    if(!flag){
                        if(c-'0' >= 7) return Integer.MAX_VALUE;
                    }else{

                        if(c-'0' >= 8) return Integer.MIN_VALUE;
                    }
                }
                result = result*10 + (c-'0');
            }else if(i!=0){
                break;
            }
        }
        if(flag) return -result;
        return result;
    }
}
