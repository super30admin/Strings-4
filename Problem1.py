#Time complexity : O(nlogn)
#Space complexity: O(n)
#Works on leetcode : yes
#Approach : We iterate through the logs and separate out the letter logs and digits logs. Then we arrange the letter logs in 
#lexographical order, when suffix is tied, we sort by identifier. Finally we return the letter logs followed by letter logs. 

class Solution:
    def reorderLogFiles(self, logs: List[str]) -> List[str]:
        num = []
        alpha = []
        for i in range(len(logs)):
            x = logs[i].split(" ")
            if x[1].isdigit():
                num.append(logs[i])
            else:
                alpha.append(logs[i].split())
        alpha.sort(key=lambda x:x[0])
        alpha.sort(key=lambda x:x[1:])
        for a in range(len(alpha)):
            alpha[a] = " ".join(alpha[a])
            
        return alpha + num