#  Time Complexity : O(N)   N is the length of the string
#  Space Complexity : O(1)  
#  Did this code successfully run on Leetcode : Yes
#  Three line explanation of solution in plain english: Initially we clear the string of leading spaces in the front and the back. We check if the first letter is a digit or if it is + or -, if neither then we return 0. If the initial letter is - then we mark the flag as False. 

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
        
        limit = 214748364  # INT_MAX // 10
        result = 0

        for i in range(len(s)):
            c = s[i]
            if c.isdigit():
                if result > limit:
                    return 2147483647 if flag else -2147483648
                elif result == limit:
                    if int(c) >= 8:
                        return 2147483647 if flag else - 2147483648
                
                result = result * 10 + int(c)
            else:
                if i != 0:
                    break

        
        return result if flag else -result