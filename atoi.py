
#Time Complexity: O(N) N is len of string

#Space Complexity: O(1)
class Solution:
    def myAtoi(self, s: str) -> int:
        if not s :
            return 0
        s= s.strip()
        if len(s)==0: #after removing white spaces if string len ==0
            return 0
        #check for sign bit
        index = 0
        sign ='+'
        if s[0] == '-':
            sign = '-'
            index+=1
        elif s[0] == '+':
            sign = '+'
            index+=1
            
        if index==0 and not s[0].isdigit():
            return 0

        res = 0
        limit  = 2**31//10
        for i in range(index,len(s)):
            if s[i].isdigit():
                val = int(s[i])
                if sign =='+':
                    if res > limit:
                        return 2**31-1
                    elif res == limit and val >7:
                        return 2**31-1
                else:

                    if res > limit:
                        return - 2**31
                    elif res == limit and val >8:
                        return - 2**31
                res = res*10+val
                
            else:
                break
        return res if sign=='+' else -res