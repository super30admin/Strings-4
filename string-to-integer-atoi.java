// Time Complexity : O(N)
// Space Complexity : O(1)

class Solution {
    public int myAtoi(String str) {
        //base case
        if(str == null || str.length() == 0) return 0;
        
        double result=0;
        boolean isNegative=false;
        int cursor=0;
        
        str=str.trim();
        if(str.length() == 0) return 0;
        
        if(str.charAt(cursor) == '+' || str.charAt(cursor) == '-') {
            if(str.charAt(cursor) == '-') isNegative=true;
            cursor++;
        }
        
        for(;cursor<str.length();cursor++) {
            char ch=str.charAt(cursor);
            if(ch < '0' || ch > '9')
                break;
            else
                result=result*10+(ch-'0');
        }
        
        if(isNegative)
            result=-1*result;
        
        if(result > Integer.MAX_VALUE)
            result=Integer.MAX_VALUE;
        else if(result < Integer.MIN_VALUE)
            result=Integer.MIN_VALUE;
        
        return (int) result;
    }
}
