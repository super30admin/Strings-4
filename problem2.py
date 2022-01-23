#Time O(nklogk), space O(n)

class Solution:
    def reorderLogFiles(self, logs: List[str]) -> List[str]:
        d=[]
        l=[]
        #letter & digit separate
        for i in logs:
            if i.split()[1].isalpha():
                l.append(i)
            else:
                d.append(i)
        
        return sorted(l,key=lambda x:(x.split()[1:],x.split()[0]) )+ d
