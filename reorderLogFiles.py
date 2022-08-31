# TC: O(nklogk)
# SC: O(1)
class Solution:
     def reorderLogFiles(self, logs: List[str]) -> List[str]:

         letters = []
         digits = []

         for log in logs:
            # separate logs in letters and digits
             if log.split()[1].isalpha():
                 letters.append(log)
             else:
                 digits.append(log)
        # sort letter logs using x.split[1:] (2nd part of logs)
        # then if they are equal, use first part of string x.split()[0]
         return sorted(letters, key=lambda x:(x.split()[1:],x.split()[0])) + digits