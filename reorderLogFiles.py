#Time Complexity: O(nklogk)
#Space Complexity: O(1)
class Solution:
    def reorderLogFiles(self, logs: List[str]) -> List[str]:
        
        letters = []
        digits = []
        
        for log in logs:
            if log.split()[1].isalpha():
                letters.append(log)
            else:
                digits.append(log)
        
        return sorted(letters, key=lambda x:(x.split()[1:],x.split()[0])) + digits