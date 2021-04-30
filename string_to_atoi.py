class Solution:
    
    # O(N) time since we have to iterate over string of characters which also could have spaces, if purely numbers safe to say O(1)
    # Space - O(1)
    def myAtoi(self, s: str) -> int:
        
        if not s:
            return 0
        
        # limits for int overflow
        MAX_LIMIT = 2147483647
        MIN_LIMIT = -2147483648
        
        # set to True = +ve sign else -ve - False
        positive = True
        
        result = 0
    
        i = 0
        
        # skip through empty white spaces
        while i < len(s) and (s[i] == ' '):
            i += 1

        # check if sign is there and record else default to True(+ve)
        if i < len(s) and (s[i] == '-' or s[i] == '+'):
            positive = False if s[i] == '-' else True
            i += 1


        while i < len(s) and s[i].isdigit():

            # check for integer overflow

            if result > MAX_LIMIT // 10 or (result == MAX_LIMIT // 10 and int(s[i]) > 7):
                return MAX_LIMIT if positive else MIN_LIMIT

            # building number
            result = result * 10 + int(s[i])
            i += 1

        # if we encounter non-digits, while loop breaks and giev out result accumulated so far with sign
        return result if positive else -result
                
                 
            
                
            