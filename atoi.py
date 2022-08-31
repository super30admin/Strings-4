# TC: O(n)
# SC: O(1)
class Solution:
    def myAtoi(self, s: str) -> int:
        # trim spaces
        s = s.strip()
        # None case
        if not s or len(s) == 0:
            return 0
        
        result = 0
        flag = False
        
        n = len(s)
        if s[0] == '-':
            flag = True
        elif s[0] == '+':
            flag = False
        elif s[0].isnumeric():
            result = ord(s[0]) - ord('0')
        else:
            return 0
        
        for i in range(1,n):
            if not s[i].isnumeric():
                break
            
            result = result * 10 + ( ord(s[i]) - ord('0'))
            # if flag is true and if result is out of bound then
            # break the loop and update result with
            # minvalue or maxvalue depending upon the sign
            if flag:
                if result * -1 < -2147483648:
                    return -2147483648
            else:
                if result > 2147483647:
                    return 2147483647
        
        if flag:
            return -1 * int(result)
        else:
            return int(result)
        
