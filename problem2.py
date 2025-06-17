# Time Complexity: O(N), where N is the length of the input string.
# Space Complexity: O(1), since we use only a few extra variables.

class Solution:
    def myAtoi(self, s: str) -> int:

        INT_MAX = 2**31 - 1
        INT_MIN = -2**31

        s = s.lstrip()
        if not s:
            return 0  # If empty after stripping, return 0

        sign = 1  # Default is positive
        index = 0  # Pointer to traverse the string
        if s[0] == '-':
            sign = -1
            index += 1
        elif s[0] == '+':
            index += 1

        num = 0
        while index < len(s) and s[index].isdigit():
            num = num * 10 + int(s[index])  # Convert char to int and build number
            index += 1

        num *= sign

        if num < INT_MIN:
            return INT_MIN
        if num > INT_MAX:
            return INT_MAX

        return num

