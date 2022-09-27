// Time: O(n)
// Space: O(1)

class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        if (s == null || s.length() == 0) return 0;
        
        int result = 0;
        boolean sign = true;
        char first = s.charAt(0);
        int limit = Integer.MAX_VALUE / 10;
        if (first == '-'){
            sign = false;
        }
        if(!Character.isDigit(first) && (first != '-' && first != '+')){
            return 0;
        }
        
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                
                if (result > limit){
                    if(sign){
                        return Integer.MAX_VALUE;
                    }else{
                        return Integer.MIN_VALUE;
                    }
                } else if(result == limit){
                    if (sign){
                        if (c -'0' >= 7){
                            return Integer.MAX_VALUE;
                        }
                    }else{
                        if (c - '0' >= 8){
                            return Integer.MIN_VALUE;
                        }
                    }
                }
                result = result * 10 + c - '0';
            }else if (i!=0){
                break;
            }
        }
        if (sign){
            return result;
        }else{
            return -result;
        }
    }
}
