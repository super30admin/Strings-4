# Time Complexity: O(M log M), where M is the number of letter-logs.
# Space Complexity: O(N), where N is the total number of logs.

class Solution:
    def reorderLogFiles(self, logs: List[str]) -> List[str]:
        def get_sort_key(log):
            identifier, content = log.split(" ", 1)  # Split the log into identifier and content
            return (content, identifier)  # Sort letter-logs by content first, then by identifier

        letter_logs = []
        digit_logs = []

        for log in logs:
            if log.split()[1].isdigit():  # Check if the second element is a digit
                digit_logs.append(log)  # Store digit-logs separately
            else:
                letter_logs.append(log)  # Store letter-logs separately

        letter_logs.sort(key=get_sort_key)

        return letter_logs + digit_logs

