class Solution:
    def myAtoi(self, s: str) -> int:
        s = s.strip()
        neg = False
        n=0
        for i in range(0,len(s)):
            if(i==0 and s[i]=="-"):
                neg = True
                continue
            if(i==0 and s[i]=="+"):
                continue
            
            c = s[i]
            if(ord(c)>=48 and ord(c)<=57):
                n = n*10 + ord(c)-ord('0')
            else:
                break
        
        
        if(neg==True):
            n = n*-1
        if(n>pow(2,31)-1):
            return pow(2,31)-1
        if(n<-1*pow(2,31)):
            return -1*pow(2,31)
        return n
