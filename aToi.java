class Solution {
    public int myAtoi(String s) {
        // Tc: O(n) Sc: O(1)
        int sign = 1;
        int ans = 0;
        int ind = 0;
        int n = s.length();

        while (ind < n && s.charAt(ind) == ' ') {
            ind++;
        }

        if (ind < n && s.charAt(ind) == '+') {
            sign = 1;
            ind++;
        } else if (ind < n && s.charAt(ind) == '-') {
            sign = -1;
            ind++;
        }

        while (ind < n && Character.isDigit(s.charAt(ind))) {

            int digit = s.charAt(ind) - '0';

            if ((ans > Integer.MAX_VALUE / 10) ||
                    (ans == Integer.MAX_VALUE / 10 &&
                            digit > Integer.MAX_VALUE % 10)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            ans = 10 * ans + digit;
            ind++;
        }

        return sign * ans;
    }
}