"""
TC O(N log N) 
SC O(1)
"""




class Solution:
    def reorderLogFiles(self, logs: List[str]) -> List[str]:
        letter = []
        number = []
       
    
        for log in logs:
            if log.split(' ')[1].isdigit():
                number.append(log)
            else:
                letter.append(log)
        
        # Sort letter logs by keys
        letter.sort(key = lambda x: (x.split(' ')[1:], x.split(' ')[0]))
    
        
        return letter + number