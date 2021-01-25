# TIME COMPLEXITY: O(n) -> upper bound by O(len of maxint)
# SPACE COMPLEXITY: O(1)
class Solution(object):
    def myAtoi(self, s):
        """
        :type s: str
        :rtype: int
        """
        # Remove whitespaces
        s = s.strip()

        # Edge cases
        if not s or ((not s[0].isdigit()) and s[0] != '+' and s[0] != '-'):
            return 0

        # Check sign
        sign = '-' if s[0] == '-' else '+'

        # Set limits to prevent overflow
        max_limit = 214748364
        res = 0

        # iterate over the string
        for i in range(len(s)):
            # Get char at index i
            c = s[i]
            if c.isdigit():
                # If the char is a digit, convert it to int
                int_c = ord(c) - ord('0')
                # Check for overflow
                if sign == '+':  # positive number
                    # If current result is > maxint/10, any incoming digit will cause overflow - return maxint
                    # If current result == maxint/10, the incoming digit must be < 7, if it is > 7, - return maxint
                    if res > max_limit or (res == max_limit and int_c > 7):
                        return 2147483647
                else:  # negative number
                    # If current result is > maxint/10, any incoming digit will cause overflow - return -maxint
                    # If current result == maxint/10, the incoming digit must be < 8, if it is > 8, - return -maxint
                    if res > max_limit or (res == max_limit and int_c > 8):
                        return -2147483648
                # No overflow, add current digit to result
                res = res * 10 + int_c
            # Handle non digit characters within the string
            # Only the first character can be a non digit - '+' or '-'
            # If any other char is a non digit, break, res will contain the int formed by the string till that point
            elif i != 0:
                break

        # Check sign and return result
        return res if sign == '+' else -res
