# // Time Complexity :O(mnlogn),,nlogn for sorting m since comparison between keys take o(m)
# // Space Complexity :O(mn),to keep keys for logs and m.n to keep intermediate values , 2 m.n , which is m.n
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no
class Solution:
    def reorderLogFiles(self, logs: List[str]) -> List[str]:
        return sorted(logs,key=self.get_key)
        
        
    def get_key(self,log):
        _id,rest=log.split(" ",maxsplit=1)
        if rest[0].isalpha():
            return (0,rest,_id)
        else:
            return (1,None,None)
        