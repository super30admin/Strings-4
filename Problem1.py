#Time Complexity: O(N)
#Space Complexity: O(1)
class Solution:
    def myAtoi(self, s: str) -> int:
        s = s.strip()
        flag = True
        if not s:
            return 0
        if not s[0].isdigit() and not (s[0] == '+' or s[0] == '-'):
            return 0
        if s[0] == '-':
            flag = False
        limit = (2**31)//10
        res = 0
        for i in range(len(s)):
            if s[i].isdigit():
                if flag:
                    if res > limit:
                        return (2**31) - 1
                    elif res == limit:
                        if int(s[i]) >= 7:
                            return (2**31) -1
                else:
                    if res > limit:
                        return -(2**31)
                    elif res == limit:
                        if int(s[i]) >= 8:
                            return -(2**31)
                res = res * 10 + int(s[i])
                
            elif i!=0 and not s[i].isdigit():
                break
                
        if flag:
            return res
        else:
            return -res
                