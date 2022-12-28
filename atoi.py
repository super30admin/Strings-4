#Time: O(n)
#Space: O(1)
#Program ran on leetcode successfully

class Solution:
    def myAtoi(self, s: str) -> int:
        if s.isspace():
            return 0
        if len(s) == 0:
            return 0
        
        isNegative = True if '-' in s else False
        hasSymbol = False
        s = s.lstrip()
        
        
        if s[0] == '-':
            hasSymbol = True
            isNegative = True
        elif s[0] == '+':
            hasSymbol = True
            isNegative = False
        elif s[0].isnumeric():
            hasSymbol = False
            isNegative = False
        else:
            return 0

        l = len(s)
        j = 0
        final = ""
        if hasSymbol:
            for i in range(1, l):
                if s[i].isnumeric() is False:
                    break
                else:
                    j = i
            final = s[0:j+1]
        else:
            for i in range(0, l):
                if s[i].isnumeric() is False:
                    break
                else:
                    j = i
            final = s[0:j+1]
            
        if final.isnumeric() is False and final[1:].isnumeric() is False:
            return 0
        
        
        val = int(final)
        print(val)
        if val<-(1<<31):
            val = -(1<<31)
        elif val>=(1<<31):
            val = (1<<31)-1
        
        return val