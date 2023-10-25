class Solution:
    def reorderLogFiles(self, logs: List[str]) -> List[str]:
        
        #TC is O(nlogn) cause we are still using the built in sorting function, but just altering the way the comparison works.
        def key_def(logs):
            id,log=logs.split(" ",1)
            if log[0].isalpha(): return (0,log,id) #if it's an letter log, put them first before digit logs, between letter logs - sort based on log 1st, if logs are same then sort based on id
            else:
                return (1,None,None) #if it's a digit log, put them after letter logs, between digit logs - do nothing - same order.
        
        return sorted(logs,key=key_def) 