class Solution:
    def myAtoi(self, s: str) -> int:
        '''
        Time Complexity: O(n), n --> length of the input string
        Space Complexity: O(1)
        '''
        s = s.lstrip()  # Remove leading whitespaces

        if not s:
            return 0  # Return 0 if the string is empty

        sign = 1  # Initialize the sign as positive
        if s[0] == '-':
            sign = -1  # Change sign to negative if a minus sign is present
            s = s[1:]
        elif s[0] == '+':
            s = s[1:]  # Remove the plus sign

        num = 0  # Initialize the resulting number
        for char in s:
            if char.isdigit():  # Check if the character is a digit
                # Check for overflow before updating the number
                if num > (2**31 - 1) // 10 or (num == (2**31 - 1) // 10 and int(char) > 7):
                    # Return maximum/minimum value if overflow occurs
                    return 2**31 - 1 if sign == 1 else -2**31
                if num < (-2**31) // 10 or (num == (-2**31) // 10 and int(char) > 8):
                    # Return maximum/minimum value if overflow occurs
                    return 2**31 - 1 if sign == 1 else -2**31
                # Update the number by appending the current digit
                num = num * 10 + int(char)
            else:
                break  # Stop parsing if non-digit character is encountered

        num *= sign  # Apply the sign to the number
        return num
