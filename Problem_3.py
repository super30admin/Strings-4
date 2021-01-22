"""
Time Complexity : O(nlogn) where n is the number of logs 
Space Complexity : O(1) not using extra space and returning the arrays
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Here, we first separate the letter logs and number logs into different lists. Afterwards, we just sort the letter logs on the 
basis of value, if that is same, then the letter log number. Once done, we concatenate the letter and digit logs and return.
"""


class Solution:
    def reorderLogFiles(self, logs: List[str]) -> List[str]:
        letters = []
        numbers = []

        for log in logs:
            if log.split()[1].isdigit():
                numbers.append(log)
            else:
                letters.append(log)
        letters.sort(key=lambda log: (log.split()[1:], log.split()[0]))
        return letters+numbers
