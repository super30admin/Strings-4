#Time Complexity: O(n)
#Space Complexity: O(1)
class Solution:
    def myAtoi(self, s: str) -> int:
        i = 0
        
        s = s.lstrip()
        
        if len(s) == 0:
            return 0
        flag = 1
        if s[0] != '+' and s[0] != '-' and not s[0].isdigit():
            return 0
        
        if s[0] == '-':
            flag = -1
        print(s,flag)
        res = 0
        for i in range(len(s)):
            
            if s[i].isdigit():
                res = res*10 + int(s[i])
                
            else:
                if not s[i].isdigit() and i != 0:
                    break
                
        res = flag*res
        
        if res< -2**31:
            res = -2**31
        
        if res> (2**31)-1:
            res = (2**31)-1
            
        return res
    