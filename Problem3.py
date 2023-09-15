class Solution:
    def reorderLogFiles(self, logs: List[str]) -> List[str]:
        '''
        Time Complexity: O(N * M * log N), custom sorting function -->O(M) time to split the log string, where M is the average length of the logs. Sorting N logs using this function takes O(N * log N) time. 
        Space Complexity:  O(N) storage of the reordered logs.
        '''
        # Custom sorting function to determine the order of logs
        def custom_sort(log):
            identifier, content = log.split(" ", 1)
            # If the content starts with a digit, it's a digit-log
            if content[0].isdigit():
                return (1, )  # Append 1 to push digit-logs to the end
            else:
                # Sort letter-logs lexicographically
                return (0, content, identifier)

        # Sort the logs using the custom sorting function
        logs.sort(key=custom_sort)
        return logs
