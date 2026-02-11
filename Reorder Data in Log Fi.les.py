#  Time Complexity : O(n * k*logk) n -> length of logs and k -> No of logs in Letter array
#  Space Complexity : O(n)  
#  Did this code successfully run on Leetcode : Yes
#  Three line explanation of solution in plain english: We create two new arrays letter and digit for storing letters and digits. Then we split the log into the identifier and the content. We check if the content is digit or letter. Upload digit and letter accordingly. Then we sort the letter array lexicographically with the content as the first key and identifier as the second key. Once sorted upload the letter logs first and then the digit logs.

class Solution:
    def reorderLogFiles(self, logs: List[str]) -> List[str]:
        letter = []
        digit = []

        for log in logs:
            splitArr = log.split(" ", 1)
            if splitArr[1][0].isdigit():
                digit.append(log)
            else:
                letter.append(log)
        
        letter.sort(key = lambda x: (x.split(" ", 1)[1], x.split(" ", 1)[0]))
        i = 0
        for s in letter:
            logs[i] = s
            i += 1
        for s in digit:
            logs[i] = s
            i += 1

        return logs 