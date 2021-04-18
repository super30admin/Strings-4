# Time Complexity : O(1)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach


class Solution:
    def myAtoi(self, s: str) -> int:
        intMax = 2147483647
        intMin = -2147483648
        s = s.strip()
        if not s:
            return 0
        sign = 1
        i = 0
        num = 0
        if s[i] == "+":
            i += 1
        elif s[i] == "-":
            i += 1
            sign = -1
        while i < len(s):
            if s[i].isdigit():
                num = (num * 10) + int(s[i])
            elif not s[i].isdigit():
                break
            i += 1
        return min(max(num * sign, intMin), intMax)
