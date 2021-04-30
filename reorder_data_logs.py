class Solution:
    
    # Time ~= O(N log N) N is length of words in letter logs
    # Space - O(M) where M is lenth of logs
    def reorderLogFiles(self, logs: List[str]) -> List[str]:
        
        letter_logs = []
        digit_logs = []
        
        # O(N)
        for log in logs:
            if log.split(' ')[1].isdigit(): # index 0 is identifier so 1 marks whther it is letter or digit
                digit_logs.append(log)
                
            else:
                letter_logs.append(log)

        # custom sort logs in letter - O(N log N) where N is lenth of letter logs
        
        letter_logs.sort(key = lambda x: (x.split(' ')[1:], x.split(' ')[0]))
                
        return letter_logs + digit_logs
        