class Solution:
    def myAtoi(self, s: str) -> int:
        s = s.strip()
        if len(s) == 0 : return 0
        res = 0
        c = s[0]
        if not c.isdigit() and c!='+' and c!='-':
            return 0
        flag = True
        if c == '-':
            flag = False
        limit = 214748364
        for i in range(len(s)):
            c = s[i]
            if c.isdigit():
                if res > limit:
                    return 2147483647 if flag else -2147483648
                elif res == limit:
                    if int(c)>=8:
                        return 2147483647 if flag else -2147483648
                res = res*10+int(c)
            else:
                if i!=0:
                    break
        return res if flag else -res

        