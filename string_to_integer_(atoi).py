class Solution:
    def myAtoi(self, s: str) -> int:
        ## T.C = O(n)
        ## S.C = O(1)

        limit = math.pow(2, 31) - 1
        lmt = limit // 10

        s = s.strip()
        if len(s) == 0:
            return 0

        if s[0] != '-' and s[0] != '+' and s[0].isdigit() == False:
            return 0

        sign = '+'
        if s[0] == '-':
            sign = '-'
        
        num = 0
        
        for i in range(len(s)):
            if s[i].isdigit():
                if sign == '+':
                    if (num == lmt and s[i] >= '7') or num > lmt:
                        return int(limit)
                else:
                    if (num == lmt and s[i] >= '8') or num > lmt:
                        return int(-limit - 1)
                num = num * 10 + int(s[i])
            elif i != 0:
                break

        if sign == '-':
            return -num

        return num

