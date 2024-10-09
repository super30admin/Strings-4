// Time Complexity: O(1)
// Space Complexity: O(1)

class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        int n = s.length();
        if (n == 0)
            return 0;

        boolean sign = true;
        char first = s.charAt(0);
        if (first == '-')
            sign = false;

        if (first != '-' && first != '+' && !Character.isDigit(first))
            return 0;

        int limit = Integer.MAX_VALUE / 10;

        int result = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                int digit = c - '0';
                if (result > limit) {
                    if (sign)
                        return Integer.MAX_VALUE;
                    else
                        return Integer.MIN_VALUE;
                } else if (result == limit) {
                    if (sign) {
                        if (digit >= 7)
                            return Integer.MAX_VALUE;
                    } else {
                        if (digit >= 8)
                            return Integer.MIN_VALUE;
                    }
                }
                result = result * 10 + digit;
            } else if (i != 0)
                break;
        }

        if (sign)
            return result;
        return -result;
    }
}