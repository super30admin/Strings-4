# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Explanation:
# Skip whitespace.
# Check sign.
# Convert digits until non-digit encountered.
# Clamp value within 32-bit integer bounds.

class Solution:
    def myAtoi(self, s: str) -> int:
        result = ""
        s = s.strip()
        pattern_abc = r"^[a-zA-Z]$"  
        if len(s) == 0 or not re.match(r"^[0-9+-]", s[0]):
            return 0
        if s[0] == "-":
            result += "-"
            s = s[1:]
        elif s[0] == "+":
            result += "+"
            s = s[1:]
        if len(s) == 0 or not re.match(r"^[0-9+-]", s[0]):
            return 0
        if s[0] == "+" or s[0] == "-":
            return 0

        pattern = r"[0-9]"

        for i in s:
            if re.match(pattern, i):
                result += i
            else:
                break

        result = int(result)
        if result < -2**31:
            return -2**31
        elif result > (2**31) - 1:
            return (2**31) - 1
        else:
            return result
