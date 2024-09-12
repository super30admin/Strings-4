# problem 1 : 8. String to Integer (atoi) : https://leetcode.com/problems/string-to-integer-atoi/
# Time Complexity : O(n) 
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None

class Solution:
    def myAtoi(self, strs: str) -> int:
        if len(strs) == 0 :
            return 0
        
        if len(strs) == 1 :
            if strs[0] == '-' or strs[0] == '+':
                return 0
        
        index = 0
        end_index = len(strs)
        acc = ['-','+']
        [acc.append(str(num)) for num in range(10)]
        for i in range(len(strs)):
            if strs[i] != ' ' and strs[i] not in acc :
                return 0
            elif strs[i] in acc :
                index = i
                break
        if index == 0 and strs[0] not in acc:
            return 0
        
        for j in range(index+1, len(strs)):
            if strs[j] == '-' or strs[j] == '+' or strs[j] not in acc :
                end_index = j
                break
                
        if strs[index:end_index] == '-' or strs[index:end_index] == '+' :
            return 0
        
        if int(strs[index:end_index]) < -2 ** 31 :
            return -2 ** 31
        elif int(strs[index:end_index]) > (2 ** 31 - 1) :
            return 2 ** 31 - 1
        else :
            return int(strs[index:end_index])
        
            
        
# problem 2 : 937. Reorder Data in Log Files : https://leetcode.com/problems/reorder-data-in-log-files/
# Time Complexity : O(M*N*log(n)) where N are total number of logs and M is size of key 
# Space Complexity : O(M*N) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None

class Solution:
    def reorderLogFiles(self, logs: List[str]) -> List[str]:
        def f(log) :
            idf, rest = log.split(" ",1)
            if rest[0].isalpha():
                return (0, rest,idf)
            else :
                return (1,)
        return sorted(logs, key = f) 
