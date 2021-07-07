// Time Complexity - O(n)
// Space Complexity - O(1)
// This solution worked on LeetCode
// With using int

class Solution {
    public int myAtoi(String str) {
        str = str.trim();
        if(str.equals("")) return 0;
        int i=0;
        int result =0;
        char first = str.charAt(0);
        int limit = Integer.MAX_VALUE/10;
        if(!Character.isDigit(first) && first != '+' && first != '-')
            return 0;
        char sign = first == '-'? '-':'+';
        while(i < str.length()){
            char c = str.charAt(i);
            if(Character.isDigit(c)){
                if(sign == '+'){
                    if(result > limit)  return Integer.MAX_VALUE;
                    else if(result == limit && c - 48 >= 7)
                        return Integer.MAX_VALUE;
                }
                else{
                    if(result > limit)  return Integer.MIN_VALUE;
                    else if(result == limit && c - 48 >= 8)
                        return Integer.MIN_VALUE;
                }
                result = result *10 + c - 48;
            }
            else if(i !=0){
                break;   
            }
            i++;            
        }
        return sign=='-' ? -result:result;
    }
}

// Using long
class Solution {
    public int myAtoi(String str) {
        str = str.trim();
        if(str.equals("")) return 0;
        int i=0;
        long result =0;
        char first = str.charAt(0);
        int limit = Integer.MAX_VALUE/10;
        if(!Character.isDigit(first) && first != '+' && first != '-')
            return 0;
        char sign = first == '-'? '-':'+';
        while(i < str.length()){
            char c = str.charAt(i);
            if(Character.isDigit(c)){
                result = result *10 + c - 48;
                if(result > Integer.MAX_VALUE){
                    if(sign == '+') return Integer.MAX_VALUE;
                    else return Integer.MIN_VALUE;
                }
            }
            else if(i !=0){
                break;   
            }
            i++;            
        }
        return sign=='-' ? -(int) result:(int) result;
    }
}
