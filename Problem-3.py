# Time Complexity : O(N log N)  # Sorting letter logs dominates
# Space Complexity : O(N)       # Separate storage for letter and digit logs
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Explanation:
# Separate logs into letter logs and digit logs.
# Sort letter logs lexicographically by content first and identifier second.
# Digit logs remain in original order and are appended at the end.

class Solution:
    def reorderLogFiles(self, logs: List[str]) -> List[str]:
        # seperate the logs into 2 groups, letter and digit. 
        l_logs = []
        d_logs = []

        for l in logs:            
            if l.split(" ")[1].isdigit():
                d_logs.append(l)
            else:
                l_logs.append(l)

        # sort the letter logs lexicographically based on the 1th element in each tuple
        # sorted based on 0th element (id) after content for tie-breakers
        l_logs.sort(key=lambda l:(l.split(" ", 1)[1], l.split(" ", 1)[0]))
        
        # putting together final output = l_logs formatted back then d_logs
        return l_logs + d_logs