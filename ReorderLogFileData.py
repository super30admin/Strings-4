from typing import List
from functools import cmp_to_key
class Solution:
    def reorderLogFiles(self, logs: List[str]) -> List[str]:
        def comparator(a,b):
            splitArr1 = a.split(" ", 1)
            splitArr2 = b.split(" ", 1)
            isDigit1 = splitArr1[1][0].isdigit()
            isDigit2 = splitArr2[1][0].isdigit()
            if (not isDigit1 and not isDigit2):
                cmp = (splitArr1[1]>splitArr2[1])-(splitArr1[1]<splitArr2[1])
                if cmp == 0 : return (splitArr1[0]>splitArr2[0])-(splitArr1[0]<splitArr2[0])
                return cmp
            elif (not isDigit1 and isDigit2):
                return -1
            elif (isDigit1 and not isDigit2):
                return 1
            else:
                return 0

        logs.sort(key = cmp_to_key(comparator))
        return logs
        