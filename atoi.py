# Time: O(n)
# Space: O(1)
# Did it run on Leetcode: yes

class Solution(object):
    def myAtoi(self, s):
        """
        :type s: str
        :rtype: int
        """
        # O(n), O(1)
        s=s.strip()
        print(s)
        if not s:
            return 0
        first=s[0]
        flag=False
        j=0
        if(first=='-'):
            flag=True
            j+=1
        elif(first=='+'):
            flag=False
            j+=1
        # if not first.isdigit() and first not in {'-', '+'}:
        #     return 0
        res=0
        max_int = (1 << 31) - 1
        min_int = -(1 << 31)
        lt=max_int//10
        for i in range(j, len(s)):
            c=s[i]
            print(c)
            if c.isdigit():
                print("yes")
                if not flag:
                    if res > lt or (res == lt and int(c) > 7):
                        return max_int
                    res = res * 10 + int(c)
                else:
                    if -res < min_int // 10 or (-res == min_int // 10 and int(c) > 8):
                        return min_int
                    res = res * 10 + int(c)
            else:
                break
        if(flag):
            if(res>(-min_int)):
                return min_int
            return -res
        return res
