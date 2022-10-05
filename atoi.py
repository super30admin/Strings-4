# Time complexity: O(n)
# Space complexity: O(1)
# Approach: check for first index character to store the sign and if its character return 0
# do (num = num*10) plus integer at index until we come across a non numeric value
# check for edge cases and sign and return


class Solution:
    def myAtoi(self, s: str) -> int:
        s = s.strip()
        if len(s)==0:
            return 0
        sign = 1
        first = s[0]
        i = 0
        if first == '+' or first == '-':
            if first == '-':
                sign = sign*-1
            i = i+1
        elif not first.isnumeric():
            return 0
        num = 0
        while i < len(s):
            c= s[i]
            if((c == '-' or c== '+') and (i!= 0)):
                break
            if(not c.isnumeric() and i!= 0):
                break
            if(c.isnumeric()):
                num = (num*10) + (ord(c)-ord('0'))
            i = i+1
        num = num* sign
        if (num < (-2 ** 31)):
            return -2 ** 31
        elif (num > (2 ** 31 - 1)):
            return 2 ** 31 - 1
        else:
            return num
            
        
            
            
        