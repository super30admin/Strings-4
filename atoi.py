class Solution:
    def myAtoi(self, s: str) -> int:
        """
        TC on
        SC o1
        """
        ls = list(s.strip())
        if len(ls) == 0:
            return 0
        sign = -1 if ls[0] == '-' else 1
        if ls[0] in ['+', '-']:
            del ls[0]
        i = 0
        cur = 0
        while i < len(ls) and ls[i].isdigit():
            cur = cur * 10 + ord(ls[i]) - ord('0')
            print(cur, i)
            i += 1
        return max(-2 ** 31, min(sign * cur, 2 ** 31 - 1))






