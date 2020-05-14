// Time Complexity: O(nlogn), where n is the number of logs
// Space Complexity: O(1)

class Solution {
    public int myAtoi(String str) {
        if(str == null || str.length() == 0) return 0;

        double result = 0;
        boolean isNegative = false;

        str = str.trim();
        if(str.length() == 0) return 0;

        int cursor = 0;

        if(str.charAt(0) == '+' || str.charAt(0) == '-') {
        	if(str.charAt(0) == '-') {
        		isNegative = true;
        	}
        	cursor++;
        }

        for(; cursor < str.length(); cursor++) {
        	char ch = str.charAt(cursor);
        	if(ch < '0' || ch > '9') {
        		break;
        	} else {
        		result = result * 10 + (ch - '0');
        	}
        }

       if(isNegative) {
        	result = -result;
       }

       if(result > Integer.MAX_VALUE) {
       		return Integer.MAX_VALUE;
       }

       if(result < Integer.MIN_VALUE) {
       		return Integer.MIN_VALUE;
       }

       return (int) result;
    }
}