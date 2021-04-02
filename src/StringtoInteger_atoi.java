
/*
 * Time Complexity of the algorithm is O(n) where n is length of the string.
 * Space Complexity is O(1)  
 */

public class StringtoInteger_atoi {

	public int myAtoi(String s) {

		s = s.trim();

		if (s == null || s.length() == 0)
			return 0;

		int result = 0;
		int limit = Integer.MAX_VALUE / 10;
		char first = s.charAt(0);

		if ((first != '+' && first != '-') && !Character.isDigit(first)) {
			return 0;
		}

		char sign = '+';
		if (first == '-') {
			sign = '-';
		}

		for (int i = 0; i < s.length(); i++) {

			char ch = s.charAt(i);

			if (Character.isDigit(ch)) {

				// handle extreme cases

				if (sign == '+') {

					if (result > limit) {
						return Integer.MAX_VALUE;
					} else if (result == limit && (ch - '0') >= 7) {
						return Integer.MAX_VALUE;
					}

				} else {
					if (result > limit) {
						return Integer.MIN_VALUE;
					} else if (result == limit && (ch - '0') >= 8) {
						return Integer.MIN_VALUE;
					}

				}

				result = result * 10 + (ch - '0');
			} else if (i != 0) {
				break;
			}

		}

		if (sign == '+')
			return result;
		return -result;

	}

}
