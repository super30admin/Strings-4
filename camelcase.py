# // Time Complexity :O(k(m+n))
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no

class Solution:
    def camelMatch(self, queries: List[str], pattern: str) -> List[bool]:
        result=[]
        for k in range(len(queries)):
            print(k)
            i=0
            flag=False
            for j in queries[k]:
                print(j,i)
               
                if i<len(pattern) and j == pattern[i]:
                        
                        i+=1
                        if i==len(pattern):
                            flag=True
                elif j.isupper():
                        flag=False
                        break
            result.append(flag)
        return result
            
                
            
        