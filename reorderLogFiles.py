#Time: O(n)
#Space: O(n)
#Program ran on leetcode successfully

class Solution:
    def reorderLogFiles(self, logs: List[str]) -> List[str]:
        digit_logs = []
        letter_logs = []
        
        for log in logs:
            if log.split()[1].isdigit():
                digit_logs.append(log)
            else:
                letter_logs.append(log)
        
        letter_logs.sort(key=lambda x: x.split()[0])
        letter_logs.sort(key=lambda x: x.split()[1:])
        
        letter_logs.extend(digit_logs)
        
        return letter_logs