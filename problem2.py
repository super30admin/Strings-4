
digits = "1234567890"
symbols = "-+"
chars = digits + symbols

def findDigits(input, index=0):
    if input[index] not in digits:
        return ""
    if index == len(input)-1:
        return input[index]
    return input[index] + findDigits(input, index+1)

class Solution:
    def myAtoi(self, str: str) -> int:     
        str = str.strip(" ")   
     
        if not str or str[0] not in chars:
            return 0
        
        sign = ""
        if str[0] in symbols and len(str) > 1:
            sign = str[0]
            str = str[1:]
        
        results = findDigits(str)
        
        if not results:
            return 0
    
        num = int(sign + results)
        if num < -2147483648:
            return -2147483648
        elif num > 2147483647:
            return 2147483647
        return num
        