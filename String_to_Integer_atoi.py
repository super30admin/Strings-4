
class Solution:
    def myAtoi(self, s: str) -> int:
        s = s.lstrip(" ")
        if not s:
            return 0
        
      
        #s = s.lstrip(" ")
        sign = 1
        start = 0
        if (s[0] != '+' and s[0] != '+') and not s[0].isdigit():
            return 0
        if s[0] == '-':
            sign = -1
            start =1
        elif s[0] == '+':
            sign = 1
            start = 1
        result = 0
        limit =  (2**31) // 10
    
        for i in range(start,len(s)):
            #print(result)
            if s[i].isdigit():
                num = int(s[i])
                if sign == 1 :
                    if result > limit:
                        return 2147483647
                    if result == limit and num >= 7:
                        return 2147483647
                else:
                    if result > limit:
                        return -2147483648
                    if result == limit and num >= 8:
                        return -2147483648
                result = result * 10 + int(num)
            elif not s[i].isdigit():
                break
                
        return result *sign                       
