# Time:- O(nlogn)
# Space:- O(1)
class Solution:
    def reorderLogFiles(self, logs: List[str]) -> List[str]:
        return sorted(logs,key = self.custom_sort)
    def custom_sort(self,logs):
        # split by ' ' this will give ['let1','8 1 5 1']
        a,b = logs.split(' ', 1)
        if b[0].isalpha():
            # 0->we want the letter logs before digit logs, b->we want to sort on the log and then if they match,a->we want to sort on the prefix
            return (0,b,a)
        else:
            # 1->we want the digit logs after the letter log 
            return (1,None,None)