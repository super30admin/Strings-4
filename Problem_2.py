"""
Time Complexity : O(1)  
Space Complexity : O(1) 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Just iterate through the string and form the result. Check edge cases and return.
"""


class Solution:
    def myAtoi(self, s: str) -> int:
        s = s.lstrip()
        result = 0
        if not s:
            return 0
        first = s[0]
        if first != '-' and first != '+' and not first.isdigit():
            return 0
        if first == '-':
            negative = True
        else:
            negative = False
        maxint = 2**31 - 1
        minint = - 2**31
        for i in range(len(s)):
            c = s[i]
            if c.isdigit():
                result = result*10 + (ord(c)-ord('0'))
            elif i != 0:
                break
        if negative:
            result = -result
        if result > maxint:
            return maxint
        if result < minint:
            return minint
        return result

# class Solution:
#     def myAtoi(self, s: str) -> int:
#         s=s.lstrip()
#         result=0
#         if not s:
#             return 0
#         first=s[0]
#         if first!='-' and first!='+' and not first.isdigit():
#             return 0
#         if first=='-':
#             negative=True
#         else:
#             negative=False
#         limit=214748364
#         for i in range(len(s)):
#             c=s[i]
#             if c.isdigit():
#                 if not negative:
#                     if result>limit:
#                         return 2147483647
#                     elif result==limit:
#                         if ord(c)-ord('0')>7:
#                             return 2147483647
#                 else:
#                     if result>limit:
#                         return -2147483648
#                     elif result==limit:
#                         if ord(c)-ord('0')>8:
#                             return -2147483648
#                 result=result*10 + (ord(c)-ord('0'))
#             elif i!=0:
#                 break
#         if negative:
#             return -result
#         return result
