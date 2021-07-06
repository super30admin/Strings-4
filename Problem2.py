"""
time:0(n)
space:o(n)
"""
class Solution(object):
    def reorderLogFiles(self, logs):
        """
        :type logs: List[str]
        :rtype: List[str]
        """
        let_logs = [] #maintaing letter and digit logs separately
        dig_logs = []

        for i in range (0,len(logs)):
            ne = logs[i].split()
            
            if(ne[1].isnumeric()):
                dig_logs.append(str(logs[i]))
            
            else:
                let_logs.append(str(logs[i]))
            
            let_logs.sort(key = lambda x: x.split()[0]) #first sort through their ids for letter logs, then through the string
            let_logs.sort(key = lambda x: x.split()[1:])
            
            res = let_logs + dig_logs    
           
        return res