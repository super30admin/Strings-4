from functools import cmp_to_key

class Solution:
    def reorderLogFiles(self, logs):
        def customSort(a, b):
            strArr1 = a.split(" ", 1)
            strArr2 = b.split(" ", 1)

            isDigit1 = strArr1[1][0].isdigit()
            isDigit2 = strArr2[1][0].isdigit()

            # if both isDigit1 and isDigit2 are letters
            # 1. we compare is one is than other, if yes we return -1
            # 2. if both are equal, we compare their identifiers
            # 3.if condition 1 and 2 are not satisfied that means strArr1 > srtArr2, and we return 1

            if not isDigit1 and not isDigit2:
                if strArr1[1] < strArr2[1]:
                    return -1
                elif strArr1[1] == strArr2[1]:
                    if strArr1[0] < strArr2[0]:
                        return -1
                    else:
                        return 1
                else:
                    return 1
            # if the first one is letter and second is digit, return -1 as we want letter log to come
            # before digit
            elif not isDigit1 and isDigit2:
                return -1
            # if first one is digit and second one is letter we return 1
            elif isDigit1 and not isDigit2:
                return 1
            # if both are digits we return 0
            else:
                return 0

        logs.sort(key=cmp_to_key(customSort))
        print(logs)
        return logs


n = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]

if __name__ == "__main__":
    obj = Solution()
    print(n)
    obj.reorderLogFiles(n)

# Time Complexity: O(nlogn)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No