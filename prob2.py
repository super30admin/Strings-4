# Time Complexity : O(n)
# Space Complexity :O(1)
# Passed on Leetcode: yes

class Solution:
    def myAtoi(self, s: str) -> int:
        # Initialize variables
        sign = 1
        result = 0
        i = 0
        n = len(s)
        
        # Remove leading whitespace
        while i < n and s[i] == ' ':
            i += 1
        
        # Check for optional sign
        if i < n and (s[i] == '+' or s[i] == '-'):
            sign = -1 if s[i] == '-' else 1
            i += 1
        
        # Process digits
        while i < n and s[i].isdigit():
            digit = int(s[i])
            
            # Check for overflow/underflow
            if result > (2**31 - digit) // 10:
                return (2**31 - 1) if sign == 1 else (-2**31)
            
            result = result * 10 + digit
            i += 1
        
        return min(max(result * sign, -2**31), 2**31 - 1)
