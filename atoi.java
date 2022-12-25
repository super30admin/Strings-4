// TC : O(n) 
// SC : O(1)

public class atoi {

class Solution {
	public int myAtoi(String s) {
		s = s.trim();

		if (s == null || s.length() == 0)
			return 0;

		int result = 0;
		char first = s.charAt(0);
		char sign = '+';

		if (first == '-') {
			sign = '-';
		}

		if ((first != '-' && first != '+') && !Character.isDigit(first)) {
			return 0;
		}

		int limit = Integer.MAX_VALUE / 10;

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			int digit = ch - '0';

			if (Character.isDigit(ch)) {
				if (result > limit) {
					if (sign == '+')
						return Integer.MAX_VALUE;
					else
						return Integer.MIN_VALUE;
				} else if (result == limit) {
					if (sign == '+') {
						if (digit >= 7)
							return Integer.MAX_VALUE;
					}

					if (sign == '-') {
						if (digit >= 8)
							return Integer.MIN_VALUE;
					}
				}

				result = result * 10 + digit;
			} else if (i > 0 && !Character.isDigit(ch)) {
				break;
			}
		}

		return sign == '-' ? -result : result;
	}
}
}
