"""
Time Complexity: O(n)
Space Complexity: O(1)
"""
class Solution:
    def myAtoi(self, s: str) -> int:
        s = s.strip()
        if len(s) == 0:
            return 0
        c = s[0]
        if not c.isdigit() and c != '+' and c != '-':
            return 0
        flag = True
        if c == '-':
            flag = False

        result = 0
        for i in range(len(s)):
            c = s[i]
            if c.isdigit():
                result = result * 10 + int(c)
                if result > 2_147_483_647:
                    return 2_147_483_647 if flag else -2_147_483_648
            else:
                if i != 0:
                    break

        return int(result) if flag else -int(result)