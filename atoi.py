# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Yes

class Solution:
    def myAtoi(self, s: str) -> int:
        sign = 1
        res = 0
        idx = 0
        n = len(s)

        # power range
        INT_MAX = pow(2, 31) - 1
        INT_MIN = -pow(2, 31)

        # discard all spaces from the beginning of the input string.
        while idx < n and s[idx] == ' ':
            idx += 1

        # sign = +1, if it's positive number, otherwise sign = -1.
        if idx < n and s[idx] == '+':
            sign = 1
            idx += 1
        elif idx < n and s[idx] == '-':
            sign = -1
            idx += 1

        # traverse next digits of input and stop if it is not a digit.
        # end of string is also non-digit character.
        while idx < n and s[idx].isdigit():
            digit = int(s[idx])

            # check overflow and underflow conditions.
            if ((res > INT_MAX // 10) or (res == INT_MAX // 10 and digit > INT_MAX % 10)):
                # if integer overflowed, otherwise if underflowed
                return INT_MAX if sign == 1 else INT_MIN

            # append current digit to the result.
            res = 10 * res + digit
            idx += 1

        # we have formed a valid number without any overflow/underflow.
        # return it after multiplying with its sign.
        return sign * res
