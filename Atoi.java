//Time Complexity : O(N) 

//Space Complexity :  O(1) 
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this :NO

//Your code here along with comments explaining your approach

/*
 * The problem asks to convert a string to integer in given string Java 
 * 
 * The solution to the problem is listed below:
 * 	1.Remove as many as white space characters until we found non white space character
 * 	2. Let "start" be storing the index of first non space white character
 *  3.let "first" be first non white space character .Check first is letter or digit.
 *   a.) If "first" is letter and is not + or - operator then return 0
 *   b.) If "first" is letter and is + or -.Let "sign" be storing the sign of number.
 *   c.) Now start traversing from "start"
 *   	i.)Let "result" be storing the converted number
 *   	ii.)Let "char" be character at index "i"
 *   	iii.) Check the "char" is digit or letter.If "char" is letter ,then convert "char" to "int" and multiply by "sig"n and return
 *   the converted value
 *   	iv.) if "char" is digit,use the following formula
 *   		result = result * 10 + char - '0';
 *   	v.) Check "sign" is positive and "result" has surpassed positive infinity, return "result"
 *   	vi.) Check "sign" is negative and "result" is lesser than negative infinity,return "result"
 *   4. Repeated the step until we have reached end of string or we found non digit character
*/
public class Atoi {
	private static char POSITIVE = '+';
	private static char NEGATIVE = '-';

	public int myAtoi(String str) {

		str = str.trim();
		if (str == null || str.length() == 0)
			return 0;//
		char firstChar = str.charAt(0);
		int sign = 1, start = 0, len = str.length();
		long sum = 0;
		if (firstChar == POSITIVE) {
			sign = 1;
			start++;
		} else if (firstChar == NEGATIVE) {
			sign = -1;
			start++;
		}
		for (int i = start; i < len; i++) {
			if (!Character.isDigit(str.charAt(i)))
				return (int) sum * sign;
			sum = sum * 10 + str.charAt(i) - '0';
			if (sign == 1 && sum > Integer.MAX_VALUE)
				return Integer.MAX_VALUE;
			if (sign == -1 && (-1) * sum < Integer.MIN_VALUE)
				return Integer.MIN_VALUE;
		}

		return (int) sum * sign;
	}
}
