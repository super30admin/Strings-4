// Time Complexity :O(n) where n is the length of the string
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach

class Solution {
    public int myAtoi(String s) {
        
        s = s.trim();
        if(s == null || s.equals("")) return 0;
        if(s.charAt(0) != '+' && s.charAt(0) != '-' && !Character.isDigit(s.charAt(0))) return 0;
        boolean flag = false;
        if(s.charAt(0) == '-') flag = true;
        int result = 0;
        int limit = Integer.MAX_VALUE/10;
        //go through all the characters in string
        //handle edge cases such as number out of range
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                if(result < limit){
                    result = (result*10) + (c - '0');
                }else if(result>limit){
                    if(flag) return Integer.MIN_VALUE;
                    else return Integer.MAX_VALUE;
                }else{
                    if(flag){
                        if(c-'0' > 7){
                            return Integer.MIN_VALUE;
                        } else{
                            result = (result*10) + (c - '0');
                        }
                    } else {
                        if(c-'0' > 6){
                            return Integer.MAX_VALUE;
                        } else{
                            result = (result*10) + (c - '0');
                        }
                    }
                }
            }else if(i != 0){
                break;
            }
        }
        if(flag) return -result;
        else return result;
    }
}