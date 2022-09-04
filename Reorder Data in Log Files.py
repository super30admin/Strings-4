""""// Time Complexity : O(nk log(k))
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
"""


class Solution:
    def reorderLogFiles(self, logs: List[str]) -> List[str]:
        def customSort(a, b):
            strArr1 = a.split(' ', 1)
            strArr2 = b.split(' ', 1)
            if not strArr1[1][0].isdigit() and not strArr2[1][0].isdigit():
                if strArr1[1] < strArr2[1]:
                    return -1
                elif strArr1[1] == strArr2[1]:
                    if strArr1[0] < strArr2[0]:
                        return -1
                    else:
                        return 1
                else:
                    return 1

            elif strArr1[1][0].isdigit() and not strArr2[1][0].isdigit():
                return 1
            elif not strArr1[1][0].isdigit() and strArr2[1][0].isdigit():
                return -1
            else:
                return 0

        logs.sort(key=cmp_to_key(customSort))
        return logs

# class Solution:
#     def reorderLogFiles(self, logs: List[str]) -> List[str]:
#         letters = []
#         numbers=[]
#         for i in logs:
#             if i.split()[1].isdigit():
#                 numbers.append(i)
#             else:
#                 letters.append(i)


#         letters.sort(key = lambda x:x.split()[0])
#         letters.sort(key = lambda x:x.split()[1:])

#         result = letters + numbers

#         return result