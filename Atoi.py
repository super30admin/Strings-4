#Time:O(1)
#Space:O(1)
class Solution:
    def myAtoi(self, s: str) -> int:
        s = s.strip()
        
        if not s:
            return 0
        if s[0] not  in "-+" and not s[0].isdigit():
            return 0
        
        result = 0
        
        MAX = "2147483647"
        i=0
        flag=1
        if s[0] in "+-":
            if s[0]=="+":
                flag=1
            else:
                flag=-1
                MAX = "2147483648"
            i=1
        
        
        list_val=[]
        
        for j in range(i,len(s)):
            if not s[j].isdigit():
                break
            if s[j]=="0" and not list_val:
                continue
            list_val.append(s[j])
        

        if len(list_val)<1:
            return 0
        
        if len(list_val)>len(MAX):
            return str(flag*int(MAX))
        elif len(list_val)<len(MAX):
            return flag*int("".join(list_val))
        
        for i in range(len(list_val)):
            if MAX[i]>list_val[i]:
                break
            elif MAX[i]<list_val[i]:
                return str(flag*int(MAX))
        
        return flag*int("".join(list_val))
        