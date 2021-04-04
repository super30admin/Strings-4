#time: O(n)
#space:O(1)

class Solution:
    MAX_INT = 2**31-1
    MIN_INT = -(2**31)
    def myAtoi(self, string: str) -> int:
        s = string.lstrip(' ')
        if not s:
            return 0
        hashmap={}
        for i in range(10):
            hashmap[str(i)]=i
        sign = -1 if s[0] == "-" else 1
        if sign != 1 or s[0] == "+":
            s = s[1:]
            
        res = 0
        for c in s:
            if c not in hashmap:
                return self.helper(res * sign)
            
            res *= 10
            res += hashmap[c]
            
        return self.helper(res * sign)
    
    def helper(self, x: int):
        if x > self.MAX_INT:
            return self.MAX_INT
        if x < self.MIN_INT:
            return self.MIN_INT
        return x