# Time:O(nlogn) sorting
# Space:O(n)
# Leetcode: Yes
# Issues:None


class Solution:
    def reorderLogFiles(self, logs: List[str]) -> List[str]:
        return sorted(logs, key = self.sorter)

    def sorter(self, logs):
        a,b = logs.split(" ",1)     # split in 2 halves
        if b[0].isdigit():
            return (2,None,None)
        else:
            return (1,b,a)          # 1(b(a))-> 2(None(None)) order


