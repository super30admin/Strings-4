class Solution:
    '''
    Accepted on leetcode(937)
    time - O(NlogN)
    space - O(1)

    '''

    def reorderLogFiles(self, logs):
        # custom sorting function
        def key(log):
            identifier, content = log.split(" ", 1)
            # if letter
            if content[0].isalpha():
                return 0, content, identifier
            # if digit
            else:
                return 1,

        return sorted(logs, key=key)

logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
sol = Solution()
print(sol.reorderLogFiles(logs))