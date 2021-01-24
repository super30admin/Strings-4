
class Solution:
    def myAtoi(self, s: str) -> int:

        s = s.strip(" ")
        if not s:
            return 0
        sign = "+"
        if s[0] == "-" or s[0] == "+":
            sign = s[0]
            s = s[1:]
        
        if not s or not s[0].isdigit():
            return 0
        result = 0

        for i in range(len(s)):
            
            if s[i].isdigit():
                
                result = result*10 + int(s[i])
            else:
                break
            
        if result >=2**31:
            if sign == "-":
                result = 2**31
            else:
                result = 2**31 -1
        return result*-1 if sign == "-" else result
    
Time : O(N)
Space: O(1)
