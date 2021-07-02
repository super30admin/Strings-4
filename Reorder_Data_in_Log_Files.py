class Solution:
    def reorderLogFiles(self, logs: List[str]) -> List[str]:
        if not logs:
            return []
        letter_log = []
        digit_log = []
        for log in logs:
            idf, actual_log = log.split(" ", maxsplit = 1)
            
            if actual_log[0].isalpha():
                letter_log.append(log)
            else:
                digit_log.append(log)
        
        def key(log):
            idf, actual_log = log.split(" ", maxsplit = 1)
            return actual_log+idf
        
        return sorted(letter_log, key=key ) + digit_log
