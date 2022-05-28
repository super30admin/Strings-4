// Time Complexity : O(n) length of the string
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Trim  empty spaces and store sign
// Build number until it is supposed to be overflowed
// If overflowing case becomes imminent then return respective max value
// Return the answer with saved sign
class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        int index = 0;
        char sign = '+';
        if(s.length() == 0)
            return 0;
        if(s.charAt(0) == '-' || s.charAt(0) == '+'){
            sign = s.charAt(0);
            index++;
        }
        int max = Integer.MAX_VALUE/10;
        int ans = 0;
        while(index < s.length() && Character.isDigit(s.charAt(index))){
            char c = s.charAt(index++);
            if(sign == '+'){
                if(ans > max || (ans == max && c > '7')){
                    return Integer.MAX_VALUE;
                }
            }
            else{
                if(ans > max || (ans == max && c > '8')){
                    return Integer.MIN_VALUE;
                }
            }
            ans = ans * 10 + (int) (c - '0');
        }
            if(sign == '-')
                ans = ans * -1;
        return ans;
    }
}