#Time Complexity: O(MNlogN)
#Space Complexity: O(M*N)
class Solution:
    def reorderLogFiles(self, logs: List[str]) -> List[str]:
        letters = []
        numbers=[]
        for i in logs:
            if i.split()[1].isdigit():
                numbers.append(i)
            else:
                letters.append(i)
         
        letters.sort(key = lambda x:x.split()[0])
        letters.sort(key = lambda x:x.split()[1:])
        
        result = letters + numbers

        return result