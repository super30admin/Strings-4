'''
Time Complexity: O(nlogn)
Space Complexity: O(1)
Did this code successfully run on Leetcode : Yes
Explanation: Create a custom comparator to sort the log files, in the custom comparator we check if both are letters if yes
we check if the content of the letters is the same lexicographically, if yes then we check if the identifiers are same lexicographically
else if we have a digit and letter we do descending else letter and digit we do ascending
'''
def reorderLogFiles(self, logs: List[str]) -> List[str]:

    def key(log):
        identifier, content = log.split(' ', 1)
        if content[0].isalpha():
            return 0, content, identifier
        else:
            return 1,

    return sorted(logs, key=key)