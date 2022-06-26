class Solution:
    def myAtoi(self, s: str) -> int:
        s=s.strip()
        if not s or len(s)==0:
            return 0
        sign=1
        num=0
        i=0
        first=s[0]
        while i<len(s):
            if first.isalpha():
                return 0
            if s[i].isdigit():
                while i<len(s) and s[i].isdigit():
                    num=num*10 + int(s[i])
                    i+=1
                    if num>=2**31:
                        if sign==1:
                            num=(2**31) -1
                            break
                        else:
                            num=2**31
                            break
                i-=1
                    
            if i<len(s) and not s[i].isdigit():
                if s[i]=='-' and i==0:
                    sign=-1
                elif s[i]=='+' and i==0:
                    sign=1
                else:
                    break
                    
            i+=1
        return sign*num
                    
        