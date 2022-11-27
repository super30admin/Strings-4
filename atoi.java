class Solution {
    //tc-o(n) sc-o(1)
    public int myAtoi(String s) {
        s = s.trim();
        if(s == null || s.length() == 0) return 0;
        //first char 
        //47 +47 -47 a47
        char first = s.charAt(0);
        char sign = '+';
        if(!(first == '+' || first == '-') && !Character.isDigit(first)) return 0;
        if(first == '-') sign = '-';
         int result =0;
        int limit = Integer.MAX_VALUE/10;
        for(int i=0;i<s.length();i++)
        {
            char c = s.charAt(i);
            boolean isDigit = Character.isDigit(c);
            if(isDigit)
            {
                if(sign == '+')
                {
                    if(result > limit) return Integer.MAX_VALUE;
                
                if(result == limit){//2147483645
                 if(c-'0' >=7) return Integer.MAX_VALUE;
                }
            }
            else
            {
                if(result > limit) return Integer.MIN_VALUE;
                if(result == limit)
                {
                    if(c-'0' >= 8) return Integer.MIN_VALUE;
                }
            }
            result = result*10 + c - '0';        
            }
            else if(i != 0 && !isDigit)//-45ab23 // i!=0 because at 0 we can have + and -
            {
             break;
            }
    }
    if(sign == '-') return -result;
    return result;
}
}