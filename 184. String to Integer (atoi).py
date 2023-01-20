class Solution:
    def myAtoi(self, s: str) -> int:
        if s is None:
            return 0
        s = s.strip()
        if len(s) == 0:
            return 0
        first = s[0]
        sign = "+"

        if first == "-":
            sign = "-"

        if first != "-" and first != "+" and not first.isnumeric():
            return 0
        result = 0
        limit = ((2 ** 31) - 1) // 10

        for i in range(len(s)):
            char = s[i]

            if char.isnumeric():
                if sign == "+":
                    if result == limit:
                        if int(char) > 7:
                            return (2 ** 31) - 1
                    elif result > limit:
                        return (2 ** 31) - 1
                else:
                    if result == limit:
                        if int(char) > 8:
                            return -(2 ** 31)
                    elif result > limit:
                        return -(2 ** 31)

                result = result * 10 + int(char)

            elif i != 0:
                break
        if sign == "-":
            return -result

        return result

# Time Complexity: O(1)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No