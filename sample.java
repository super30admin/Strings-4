// String to Integer (atoi)
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public int myAtoi(String s) {
        int sign = 1;
        int current = 0;
        int result = 0;
        
        // skipping over spaces
        while (current < s.length() && s.charAt(current) == ' ') {
            current += 1;
        }
        
        if (current == s.length()) {
            return 0;
        }
        // getting the sign of the integer
        if (s.charAt(current) == '-') {
            sign = -1;
            current += 1;
        } else if (s.charAt(current) == '+') {
            sign = 1;
            current += 1;
        }
        // looping over the string
        while (current < s.length()) {
            // if a char, return 0
            int digit = getDigit(s.charAt(current));
            if (digit == -1) {
                return result * sign;
            } else if (result > (Integer.MAX_VALUE - digit) / 10) { // if crossed integer limits, then return accordingly
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            // else keep calculating the integer
            result = result * 10 + digit;
            current += 1;
        }
        // return the integer
        return sign * result;
    }
    // getting if the char is digit or no
    private int getDigit(char c) {
        int digit = c - '0';
        return digit >= 0 && digit <= 9 ? digit : -1;
    }
}

// Reorder Data in Log Files
// Time Complexity: O(n)
// Space Complexity: O(n) for array

class Solution {
    public String[] reorderLogFiles(String[] logs) {
        if (logs == null || logs.length == 0) {
            return logs;
        }
        
        int dig = logs.length - 1;
        int let = 0;
        String[] result = new String[logs.length];
        // looping over array to get letters to the front and digits after letters
        for (int i=logs.length - 1; i>=0; i--) {
            String str = logs[i];
            if (str.startsWith("dig")) {
                result[dig] = str;
                dig -= 1;
            } else {
                result[let] = str;
                let += 1;
            }
        }
        //sorting letters lexicographically
        Arrays.sort(result, 0, let, new Comparator<String>() {
            public int compare(String log1, String log2) {
                int let1 = log1.indexOf(" ");
                int let2 = log2.indexOf(" ");
                
                return log1.substring(let1).compareTo(log2.substring(let2));
            }
        });
        
        return result;
    }
}
