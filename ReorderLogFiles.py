'''
Solution:
1.  Firstly, allocate logs and digits to corresponding lists.
2.  Sort the letters based on logs and the sorted ones on alphabetical order to match the priority mentioned
    in the question.
3.  Join the letters which are in split manner and concatenate letters with digits list.

Time Complexity:    O(N) -- N is the number of logs
Space Complexity:   O(1) -- not using any extra space other than the return type as we are concatenating both the lists in the end.

--- Passed all testcases on leetcode successfully.
'''


class Solution:
    def reorderLogFiles(self, logs: List[str]) -> List[str]:

        #   initilaizations and allocating logs and digits to corresponding lists
        letters, digits = [], []

        for log in logs:
            tokens = log.split(' ')
            if (tokens[1].isdigit()):
                digits.append(log)
            else:
                letters.append(tokens)

        #   first, sort the letters based on logs and the sorted ones on alphabetical order to match the priority mentioned
        #   in the question
        letters.sort(key=lambda log: log[0])
        letters.sort(key=lambda log: log[1:])

        #   join the letters again
        for i in range(len(letters)):
            letters[i] = ' '.join(letters[i])

        #   concatenate letters and digits
        return letters + digits