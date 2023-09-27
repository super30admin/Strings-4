//O(n) time 
//O(1) space
class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        //null
        if(s == null || s.length() == 0) return 0;
        //first char
        char first = s.charAt(0);
        char sign = '+';
        if(!(first == '+' || first == '-') && !Character.isDigit(first)) return 0; //ab46
        int result = 0;
        if(first == '-') sign = '-';
        int limit = Integer.MAX_VALUE / 10;
        for(int i=0; i< s.length(); i++){
            //+43 -43 43
            char c = s.charAt(i);
            boolean isDigit = Character.isDigit(c);
            if(isDigit){
                if(sign == '+'){
                    if(result > limit) return Integer.MAX_VALUE;
                    if(result == limit){
                        if(c - '0' >= 7) return Integer.MAX_VALUE;
                    }
                }else{
                    if(result > limit) return Integer.MIN_VALUE;
                    if(result == limit){
                        if(c - '0' >= 8) return Integer.MIN_VALUE;
                    }
                    
                }
                result = result * 10 + c - '0';
            }else if(i != 0 && !isDigit){ //not a digit -342asb
                break;
            }
        }
        if(sign == '-') return -result;
        return result;
    }
}
