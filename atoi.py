'''
Time Complexity : O(1)  
Space Complexity : O(1) 
'''

class Solution:
    def myAtoi(self, s: str) -> int:
        s = s.lstrip()
        if not s:
            return 0
        
        result = 0
        
        limit = 214748364
        first = s[0]
        if first != '+' and first != '-' and not first.isdigit():
            return 0
        neg = True
        if first == '-':
            neg = True
        else:
            neg = False
        
        for i in range(len(s)):
            c = s[i]
            if c.isdigit():
                if not neg:
                    if result>limit:
                        return 2147483647
                    elif result==limit:
                        if ord(c)-ord('0')>7:
                            return 2147483647
                else:
                    if result>limit:
                        return -2147483648
                    elif result==limit:
                        if ord(c)-ord('0')>8:
                            return -2147483648
                result=result*10 + (ord(c)-ord('0'))
            elif i!=0:
                break
                
                    
        if neg:
            return -result
        else:
            return result
        
            
            
        