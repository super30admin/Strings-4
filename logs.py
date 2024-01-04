# Time: O(nlogn)
# Space: O(1)
# Did it run on Leetcode: yes

class Solution(object):
    def reorderLogFiles(self, logs):
        """
        :type logs: List[str]
        :rtype: List[str]
        """
        def custom_sort(log):
            identifier, content = log.split(" ", 1)
            return (0, content, identifier) if content[0].isalpha() else (1,)

        logs.sort(key=custom_sort)
        return logs
