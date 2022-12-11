//Time - O(1)
//Space - O(1)
class Solution {
    public int myAtoi(String s) {
        if(s==null || s.length() ==0) return 0;
        s = s.trim();
        if(s==null || s.length() ==0) return 0;
        boolean sign = true;
        if(s.charAt(0) == '-') sign = false; 

        if((s.charAt(0) != '-' && s.charAt(0)!= '+') && !Character.isDigit(s.charAt(0))) return 0;
        int result =0;
        int limit = Integer.MAX_VALUE/10;
        for(int i=0; i<s.length(); i++){
            if(Character.isDigit(s.charAt(i))){
              
                if(result > limit){
                    if(sign) return Integer.MAX_VALUE;
                    else return Integer.MIN_VALUE;
                }else if(result == limit){
                    if(sign){
                        if(s.charAt(i)-'0' >= 7) return Integer.MAX_VALUE;
                    }else{
                        if(s.charAt(i)-'0' >= 8) return Integer.MIN_VALUE;
                    }
                }
                  result = result*10+s.charAt(i)-'0';
            }else if(i!=0){
                if(sign) return result;
                else return -result;
            }
        }
           if(sign) return result;
           else return -result;


    }
}