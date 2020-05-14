'''
Time Complexity: O(n)
Space Complexity: O(n) -> result space
Did this code successfully run on Leetcode : Yes
Explanation: Atoi is composition of the following: remove white spaces, add -tive or positive at the end, keep creating the
result until we see a character. Also handle cases for overflow.
'''
class Solution:
    def myAtoi(self, str: str) -> int:
        if str == None or len(str) == 0:
            return 0

        result = 0
        isNegative = False

        cursor = 0

        # remove space from starting

        str = str.strip()

        if len(str) == 0:
            return 0

        # check for sign
        if str[0] == '+' or str[0] == '-':
            if str[0] == '-':
                isNegative = True
            cursor += 1

        for c in range(cursor, len(str)):
            ch = str[c]
            if ord(ch) < ord('0') or ord(ch) > ord('9'):
                break
            else:
                result = result * 10 + (ord(ch) - ord('0'))

        if isNegative:
            result = -result

        if result < -2147483648:
            return -2147483648

        if result > 2147483647:
            return 2147483647

        return result

