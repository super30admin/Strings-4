//Time: O(N) | Space: O(1)

class Solution {
    public int myAtoi(String s) {
        if (s.length() == 0) return 0;
        s = s.trim();
        if (s.length() == 0) return 0;
        char firstChar = s.charAt(0);
        if (firstChar != '+' && firstChar != '-' && !Character.isDigit(firstChar)) return 0;
        boolean isMinusSign = false;
        int maxDefault = Integer.MAX_VALUE / 10;
        int minDefault = Integer.MIN_VALUE / 10;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!Character.isDigit(c)) {
                if (i != 0) break;
                else if (c == '-') isMinusSign = true;
            } else {
                int currVal = c - '0';
                if (isMinusSign) {
                    if (result > 0) {
                        result *= -1;
                    }
                    //edge cases - integer flow cases
                    if (result < minDefault || (result == minDefault && currVal >= 8)) return Integer.MIN_VALUE;
                } else if (result > maxDefault || (result == maxDefault && currVal >= 7)) return Integer.MAX_VALUE;

                result = result * 10 + (isMinusSign ? -currVal : currVal);
            }
        }
        return result;
    }
}