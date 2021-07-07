class Solution {
    public int myAtoi(String str) {
        
        str = str.trim();
        int retval =0;
        if(str.length()==0 || (!Character.isDigit(str.charAt(0))  && str.charAt(0)!='+' && str.charAt(0)!='-' )){
            return retval;
        }
        char sign = str.charAt(0) == '-'? '-':'+';
        int maxLimit = Integer.MAX_VALUE/10;
        
        for(int i=0; i<str.length(); i++){
            char ch= str.charAt(i);
            if(Character.isDigit(ch)){
                if(retval > maxLimit){  // max_value = 12345, 1234 = max limit and retval is 1235  
                    return (sign == '-')?  Integer.MIN_VALUE:Integer.MAX_VALUE   ;
                }
                else if(retval == maxLimit){
                    if(sign == '+'){
                        if(ch >= '7') return Integer.MAX_VALUE;
                    }
                    else {
                        if(ch >= '8') return Integer.MIN_VALUE;
                }
            }
            
            retval = retval*10+ (ch - 48);
            
        } else if (i!= 0) break;
        
     }
        if(sign == '-'){
            return -retval;
        }
        
        return retval;
        
        
    }
}
