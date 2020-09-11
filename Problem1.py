"""
time: o(n)
space: o(1)
"""
class Solution(object):
    def myAtoi(self, str):
        """
        :type str: str
        :rtype: int
        """
        str = str.strip() #trimmin the spaces
        if not str:
            return 0
        if not str[0].isdigit() and str[0] != "+" and str[0] != "-" : #invalid conditions for first index
            return 0
        
        if str[0] == "-": #maintaining sign
            sign = "-"
        else:
            sign = "+"
        
        num = 0
        max_val = 214748364    #maxint value /10
        for i in range(len(str)):
            if str[i].isdigit():
                
                if sign == "+":
                    if num > max_val: #if the number is already greater than the limit, it is obvious that it will be greater than maxint value 
                        return 2147483647
                    if num == max_val: #if its equal, check for next number
                        if int(str[i]) > 7:
                            return 2147483647
                else: #for - value
                    if num > max_val:
                        return -2147483648
                    if num == max_val:
                        if int(str[i]) > 8:
                            return -2147483648
                
                num = num * 10 + int(str[i]) 
                
                
            if i != 0 and not str[i].isdigit(): #if non integer value is encountered, break
                break
        if sign == "-":
            num = num * -1
            
        return int(num)