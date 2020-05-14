// Time Complexity :o(n)
// Space Complexity :o(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int myAtoi(String str) {
        if(str.length() ==0) return 0;
        
       str= str.trim();
        if(str.length() ==0) return 0;
        double res=0;
        int sign=1;
        int cursor=0;
        if(str.charAt(0) == '+'){
          sign =1 ; 
            cursor++;
        }
        if(str.charAt(0) =='-'){
            sign = -1;
             cursor++;
        }

         for(;cursor<str.length();cursor++){
             char ch =str.charAt(cursor);
             if(ch <'0' || ch>'9' ){
                 break;
             }
        else{
         res= (res*10)+(ch-'0');
        }
         }
        
        res=sign*res;
        if(res > Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        if(res < Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        return (int) res;
    }
}