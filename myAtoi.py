"""
TC O(N) ---> O(len of maxint) 
SC O(1)

"""

class Solution:
    def myAtoi(self, s: str) -> int:
        s = s.strip()

        if not s or ((not s[0].isdigit()) and s[0] != '+' and s[0] != '-'):
            return 0

      
        sign = '-' if s[0] == '-' else '+'

        # Set limits to prevent overflow
        max_limit = 214748364 #integer.MAX_VALUE to prevent overflow  2**31 - 1
        res = 0
        
        
        """
        Positive Number :
        If current result is > maxint/10, any incoming digit will cause overflow - return maxint
        If current result == maxint/10, the incoming digit must be < 7, if it is > 7, - return maxint
        
        Negative Number:
        If current result is > max_int/10, any incoming digit will cause overflow - return -max_int
        If current result == max_int/10, the incoming digit must be < 8, if it is > 8, - return -max_int
        
        
        """

       
        for i in range(len(s)):
            #get char at idx i
            c = s[i]
            if c.isdigit():#if digit then covert to str
                int_c = ord(c) - ord('0')
                if sign == '+':  # positive number
                    if res > max_limit or (res == max_limit and int_c > 7):
                        return 2147483647 #maxlimit 2**31-1
                else:  # negative number
                 
                    if res > max_limit or (res == max_limit and int_c > 8):
                        return -2147483648 #min limimt - 2**31
                # No overflow, add curr digit to result
                res = res * 10 + int_c
                """
                Handle non digit characters within the string.Only the first ch can be a non digit - '+' or '-'. If any other char is a non digit, break, res will contain the int formed by the string till this point in code.
                
                """
          
            elif i != 0:
                break

        # Check sign and return result
        return res if sign == '+' else -res
        