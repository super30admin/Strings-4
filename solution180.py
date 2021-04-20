#Time Complexity:O(1)
#Space Complexity:O(1)
##All the white spaces are removed from the front. The first element of the stripped string is considered, if it is an alphabet 0 is returned.
##if '-' is encountered the nagative boolean value is set. Max and minimum integer values are defined and the string is later converted into 
##integer. if negative is set and result is within the max and min values it is returned accordingly. 
class Solution:
    def myAtoi(self, s: str) -> int:
        s=s.lstrip()
        result=0
        if not s:
            return 0
        first=s[0]
        if first!='+' and first!='-' and not first.isdigit():
            return 0
        if first=='-':
            negative=True
        else:
            negative=False
        maxint=2**31-1
        minint=-2**31
        for i in range(len(s)):
            ch=s[i]
            if ch.isdigit():
                result=result*10+(ord(ch)-ord('0'))
            elif i!=0:
                break
        if negative:
            result=-result
        if result>maxint:
            return maxint
        if result<minint:
            return minint
        return result