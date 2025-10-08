//TC: O(n): trim + single left-to-right scan over the string.
//SC: O(1): only a few variables (flag, result, c) regardless of input size.

//Trim leading/trailing spaces; read optional sign to set flag.
//Scan characters left→right: if digit, do result = result*10 + (c-'0'); on first non-digit after index 0, stop.
//If result > Integer.MAX_VALUE, clamp to INT_MAX/INT_MIN by flag; otherwise return result with the sign.

class Solution {
    public int myAtoi(String s) {

        s = s.trim();

        if(s.length() == 0) return 0;
        char c = s.charAt(0);
        if(!Character.isDigit(c) && c != '+' && c != '-') return 0;
        boolean flag = true;

        if(c == '-'){
            flag = false;
        }

        long result = 0;
       
        for(int i=0; i<s.length(); i++){ 
            c = s.charAt(i);

            if(Character.isDigit(c)){
                result = result * 10 + c - '0';

                if(result > Integer.MAX_VALUE){
                    if(flag) return Integer.MAX_VALUE;
                    else return Integer.MIN_VALUE;
                }
            }else{
                if(i != 0) break;
            }
        }

        if(flag) return (int)result;
        else return -(int)result;
    }
}
