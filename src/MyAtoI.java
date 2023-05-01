//Time Complexity : O(N)
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/**
 * Traverse each index and check if it is a digit, if so, add it to the result
 * and check if it crosses max value. If so return max value else return the
 * result.
 *
 */
class Solution {
	public int myAtoi(String s) {
		int sign = 1;
		int result = 0;
		int idx = 0;
		int n = s.length();

		while (idx < n && s.charAt(idx) == ' ')
			idx++;
		if (idx < n && s.charAt(idx) == '+') {
			idx++;
		} else if (idx < n && s.charAt(idx) == '-') {
			sign = -1;
			idx++;
		}

		while (idx < n && Character.isDigit(s.charAt(idx))) {
			int digit = s.charAt(idx) - '0';
			if ((result > Integer.MAX_VALUE / 10)
					|| (result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10))
				return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			result = result * 10 + digit;
			idx++;
		}
		return sign * result;
	}
}