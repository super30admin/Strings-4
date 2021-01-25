# TIME COMPLEXITY: O(MK log K) where k is length of letter logs
# SPACE COMPLEXITY: O(M+N) - Two lists to store the logs
class Solution(object):
    def reorderLogFiles(self, logs):
        """
        :type logs: List[str]
        :rtype: List[str]
        """
        letter = []
        digit = []
        
        # Separate and store logs in two different lists
        for log in logs:
            if log.split(' ')[1].isdigit():
                digit.append(log)
            else:
                letter.append(log)
        
        # Sort letter logs by keys
        letter.sort(key = lambda x: (x.split(' ')[1:], x.split(' ')[0]))
        
        # Combine the two lists
        result = letter + digit
        
        return result