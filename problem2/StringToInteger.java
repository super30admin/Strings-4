// Time Complexity : O(n), n -> Length of string
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem2;

public class StringToInteger {
	public int myAtoi(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		s = s.trim();

		if (s.length() == 0) {
			return 0;
		}

		char sign = '+';
		char first = s.charAt(0);

		if (first == '-') {
			sign = '-';
		}

		if (first != '-' && first != '+' && !Character.isDigit(first)) {
			return 0;
		}

		int num = 0;
		int limit = Integer.MAX_VALUE / 10;

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			int val = ch - '0';

			if (Character.isDigit(ch)) {
				if (sign == '+') {
					if ((num > limit) || (num == limit && val > 7)) {
						return Integer.MAX_VALUE;
					}
				} else {
					if ((num > limit) || (num == limit && val > 8)) {
						return Integer.MIN_VALUE;
					}
				}

				num = num * 10 + val;
			} else if (i != 0) {
				break;
			}
		}

		return sign == '-' ? -num : num;
	}

	public static void main(String[] args) {
		StringToInteger obj = new StringToInteger();
		String str = "-91294014";
		System.out.println("Integer number: " + obj.myAtoi(str));
	}

}
