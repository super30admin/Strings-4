# Time:O(n) 1 pass
# Space:O(n) storing res
# Leetcode: Yes
# Issues:None

class Solution:
    def myAtoi(self, s: str) -> int:
        s = s.strip()
        if len(s) == 0:
            return 0

        c = s[0]                                    # check incoming
        if not c.isdigit() and c!='+' and c!= '-':  # weird char
            return 0
            
        idx = 0                                 
        isNegative = 1

        if c == '-':                               # anytime tou see a -, its negative
            isNegative = -1
            idx += 1

        if c == '+':                               # increment once if you see a +
            idx += 1
        
        res = ""                                   # we use a string builder
        for i in range(idx, len(s)):
            if s[i].isdigit():
                res  += s[i]
            else:
                break
        
        if res == "":                              # string empty? return 0
            return 0

        num = isNegative * int(res)                # modify res to match its sign

        minl,maxl = -2**31, 2**31-1                # compare limits

        if num < minl:
            return minl
        if num > maxl:
            return maxl

        return num 