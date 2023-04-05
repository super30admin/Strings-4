class Solution:
    def reorderLogFiles(self, logs: List[str]) -> List[str]:
        list1=[]
        list2=[]
        for i in logs:
            k=i.split()
            if k[1].isdigit():
                list2.append(i)
            else:
                list1.append(i)
        list1=sorted(list1,key=lambda x:(x.split()[1:],x.split()[0]))
        return list1+list2