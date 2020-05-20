'''
Solution:
1.  Firstly, strip the string with tailing white spaces which is O(N) time, where N is the length of the string.
2.  Move the cursor, until a non-digit appears, and keep updating the final number in parallel after checking whether
    the number is negative or not.
3.  Handle the edge cases of Long Ints, negative numbers and return the final result.

Time Complexity:    O(N)    N -- length of the string
Space Complexity:   O(1)

--- Passed all testcases on leetcode successfully.
'''


class Solution:
    def myAtoi(self, str: str) -> int:

        #   edge case checks, before and after stripping the string with tailing white spaces
        if (str == None or len(str) == 0):
            return 0

        result = 0
        string = str.strip()
        if (len(string) == 0):
            return 0

        #   check for whether the number in the string is negative or not
        cursor = 0
        isNegative = False
        if (string[0] == '-' or string[0] == '+'):
            if (string[0] == '-'):
                isNegative = True
            cursor += 1

        #   traverse until you find the first non-digit and till then update the number formed
        while (cursor < len(string)):

            currentChar = string[cursor]

            if (ord(currentChar) < ord('0') or ord(currentChar) > ord('9')):
                break
            else:
                result = (result * 10) + (ord(currentChar) - ord('0'))

            cursor += 1

        if (isNegative):
            result = -result

        #   edge case for long ints
        if (result < (-2 ** 31)):
            return -2 ** 31
        elif (result > (2 ** 31 - 1)):
            return 2 ** 31 - 1
        else:
            return result