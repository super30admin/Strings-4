class Solution:
    def myAtoi(self, s: str) -> int:
        s=s.strip()
        isneg=False
        res=0
        if not s: return 0 #if after strippping white chars nothignn is left-> 0
        if s[0]=='-': isneg=True
        elif s[0]=='+': isneg=False
        elif not s[0].isnumeric(): return 0 #if first char isn't a number ->0
        else:
            res=ord(s[0])-ord('0') #calc the 1st digit
        for i in range(1,len(s)):
            if s[i].isnumeric(): #if a digit
                res=res*10+(ord(s[i])-ord('0'))
                if not isneg and res>2**(31)-1: return 2**(31)-1 #if it isn't neg and our res is bigger than 2**(31)-1 then return 2**(31)-1 - gien in ques
                if isneg and res>(2**(31)):  return -(2**(31)) #if it is neg and our res is bigger than 2**(31) then return -2**(31) - gien in ques
            else: #moment it isn't a digit, stop
                break
        if not isneg: return res
        return -res