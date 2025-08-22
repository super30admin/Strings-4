"""
Time Complexity: O(k * nlogn)
Space Complexity: O(1)
"""
class Solution:
    def reorderLogFiles(self, logs: List[str]) -> List[str]:
        def sortKey(log):
            splitArr = log.split(" ", 1)
            isDigit = splitArr[1][0].isdigit()
            return (1, ) if isDigit else (0, splitArr[1], splitArr[0])

        return sorted(logs, key=sortKey)