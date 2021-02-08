// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class Solution {
    public int myAtoi(String str) {
        // "   -42"
        // "abc 123"
        if(str.length() == 0)
            return 0;
        
        int i=0;
        int factor =1;
        int n = str.length();
        
        while(i<n && str.charAt(i)==' '){
            i++;
        }
        if(i>=n)
            return 0;
        if(str.charAt(i)=='+' || str.charAt(i)=='-'){
            factor = str.charAt(i)=='+' ? 1 : -1;
            i++;
        }
        
        long res = 0;
        while(i<n && Character.isDigit(str.charAt(i))){
            res = res*10 + str.charAt(i) - '0';
            if(res > Integer.MAX_VALUE || res < Integer.MIN_VALUE ){
                return factor==1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            i++;
        }
        return (int) res*factor;
    }
        
}