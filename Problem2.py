#Time complexity : O(n)
#Space complexity: O(1)
#Works on leetcode : yes
#Approach : First check for the sigh and save  and remove it from original string. Then iterate through string and process only if 
#it's a digit. If first char is a letter, the while loop is not processed. Finally we return the sign multiplied by ans given that
#its within the Int range

class Solution:
    def myAtoi(self, str: str) -> int:
        
        stt = list(str.strip())
        if not stt:
            return 0
        sign = -1 if stt[0]=='-' else 1
        if stt[0] in ('-','+'):
            del stt[0]
        print(stt)
        ans, i = 0,0
        while i<len(stt) and stt[i].isdigit():
            ans = ans*10 + ord(stt[i])-ord('0')
            i+=1
        return max(-2**31, min(sign*ans, 2**31-1))