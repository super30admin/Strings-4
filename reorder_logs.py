# Time Complexity : O(mlogn)
# Space Complexity : O(nm)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

from typing import List


class Solution:
    def reorderLogFiles(self, logs: List[str]) -> List[str]:

        letter, digit = [], []

        # split the list into digit and letter
        for log in logs:
            if log.split()[1].isalpha():
                letter.append(log)
            else:
                digit.append(log)

        # sort the letter list by its contents, if contents are the same, sort it by its identifier
        letter.sort(key=lambda x: (x.split()[1:], x.split()[0]))

        return letter + digit
