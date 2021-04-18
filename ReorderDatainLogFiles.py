# Time Complexity : O(NlogN)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Sort th


class Solution:
    def reorderLogFiles(self, logs: List[str]) -> List[str]:
        return sorted(logs, key=self.sort)

    def sort(self, logs):
        a, b = logs.split(' ', 1)
        if b[0].isalpha():
            return (0, b, a)
        else:
            return (1, None, None)
