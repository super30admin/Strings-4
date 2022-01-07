class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        if(s == null || s.length() == 0) return 0;
        char sign = '+';
        char first = s.charAt(0);
        if(first == '-'){
            sign = '-';
        }
        
        int limit = Integer.MAX_VALUE/10;
        if(first != '+' && first != '-' && !Character.isDigit(first)) return 0;
        
        int result= 0;
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            
            if(Character.isDigit(c)){
                if(sign == '+'){
                    if(result > limit) return Integer.MAX_VALUE;
                    else if(result == limit && c - '0' >= 7){
                        return Integer.MAX_VALUE;
                    }
                }else{
                    if(result > limit) return Integer.MIN_VALUE;
                    else if(result == limit && c - '0' >= 8){
                        return Integer.MIN_VALUE;
                    }
                }
                result = result * 10 + c - '0';
            }else if( i != 0){
                break;
            }
        }
        if(sign == '+') return result;
        return -result;
    }
}

//TC: O(n)
//SC: O(1)
