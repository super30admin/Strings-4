// Problem: String to Integer (atoi)
// Time complexity: O(n), where n is the length of the string.
// Space complexity: O(1), as we are using a constant amount of extra space.
// Did this code run successfully on LeetCode: Yes

// Approach:
// 1. Skip leading whitespace characters.
// 2. Check for an optional sign ('+' or '-').
// 3. Convert the string to an integer, handling overflow.
// 4. Return the result, ensuring it is within the 32-bit signed integer range.

#include <string>
#include <limits>
using namespace std;
class Solution {
public:
    int myAtoi(string s) {
        int i = 0, n = s.size();
        while (i < n && s[i] == ' ') i++;  // Skip leading spaces

        if (i == n) return 0;

        // Handle sign
        int sign = 1;
        if (s[i] == '+' || s[i] == '-') {
            if (s[i] == '-') sign = -1;
            i++;
        }

        long result = 0;
        while (i < n && isdigit(s[i])) {
            int digit = s[i] - '0';

            // Overflow check
            if (result > (INT_MAX - digit) / 10) {
                return sign == 1 ? INT_MAX : INT_MIN;
            }

            result = result * 10 + digit;
            i++;
        }

        return sign * result;
    }
};
