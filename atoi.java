// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Main {
    public static int myAtoi(String s) {
        // trim the strinng to remove space
        // from front and end
        s = s.trim();
        // null case
        if (s == null || s.length() == 0)
            return 0;
        // to store the result
        // I have taken long to avoid out of bound for
        // integer
        long result = 0;
        // to store the sign I am using flag
        boolean flag = false;
        int n = s.length();
        // if first char is - make flag is true
        // if it is number store it inside the result
        // else return 0
        if (s.charAt(0) == '-') {
            flag = true;
        } else if (s.charAt(0) == '+') {
            flag = false;
        } else if (Character.isDigit(s.charAt(0))) {
            result = s.charAt(0) - '0';
        } else {
            return 0;
        }
        // start from index 1
        for (int i = 1; i < n; i++) {
            // if character is not digit
            // break the loop
            if (!Character.isDigit(s.charAt(i))) {
                // if(flag) return -1*(int)result;
                // else return (int)result;
                break;
            }
            // System.out.println(flag);
            result = result * 10 + (s.charAt(i) - '0');
            // update the result
            // if flag is true and if result is out of bound then
            // break the loop and update result with
            // minvalue or maxvalue depending upon the sign
            if (flag) {
                if (result * -1 < Integer.MIN_VALUE) {
                    // return Integer.MIN_VALUE;
                    result = -Integer.MIN_VALUE;
                    break;
                }
            } else {
                if (result > Integer.MAX_VALUE) {
                    // return Integer.MAX_VALUE
                    result = Integer.MAX_VALUE;
                    break;
                }
            }

        }
        if (flag)
            return -1 * (int) result;
        else
            return (int) result;
    }

    public static void main(String[] args) {
        String s = "123 Mayank";
        System.out.println(myAtoi(s));
    }
}