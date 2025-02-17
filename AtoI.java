// Approach : Linear scan and protect from getting integer overflow error.
// Time : O(N)
// Space :  O(1)
class Solution {
    public int myAtoi(String s) {
        // Step 1: Trim white spaces
        s = s.trim();
        if (s.length() == 0)
            return 0;

        char ch = s.charAt(0);
        // Step 2: First character is not a digit or not + sign or not - sign then it is
        // a character which is then invalid
        if (!Character.isDigit(ch) && ch != '+' && ch != '-')
            return 0; // invalid digit

        boolean isNegative = false;
        if (ch == '-') {
            isNegative = true;
        }

        int result = 0;
        // Max Value : 2147483647 - 10 digits
        // limit : 2147483627 / 10 = 214747364 - 9 digits
        int limit = Integer.MAX_VALUE / 10; // 9 digits log

        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i); // 42
            if (Character.isDigit(ch)) {
                if (result > limit) {
                    if (isNegative)
                        return Integer.MIN_VALUE;
                    else
                        return Integer.MAX_VALUE;
                } else if (result == limit) {
                    // we need to process them based on the current incoming digit
                    if (isNegative) {
                        // last character we can allow is 8 -> -2147483647
                        if (ch - '0' >= 8)
                            return Integer.MIN_VALUE;
                    } else {
                        // last character we can allow is 7 -> 2147483647
                        if (ch - '0' >= 7)
                            return Integer.MAX_VALUE;
                    }
                }
                // result is less than limit
                result = result * 10 + ch - '0';
            } else {
                // 0th character can be negative sign or positve sign
                if (i != 0)
                    break;
            }
        }

        if (isNegative)
            return -1 * result;
        return result;
    }
}