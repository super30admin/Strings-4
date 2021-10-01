
#Time Complexity: O(NklogN) N is # string in log list , k is len of each string 

#Space Complexity: O(1)

from functools import cmp_to_key
class Solution:
    def reorderLogFiles(self, logs: List[str]) -> List[str]:
        if not logs or len(logs)==0:
            return []
        
        def compare(item1, item2):
            items_1 = item1.split(' ',1) #one split
            items_2 = item2.split(' ',1)
            
            d1 = items_1[1][0].isdigit()
            d2 = items_2[1][0].isdigit()
            if d1 and d2: #both are digits
                return 1
                
            elif not d1 and not d2: #both are letters
                if items_1[1]==items_2[1]:
                    if items_1[0] < items_2[0]:
                        return -1
                    else:
                        return 1
                elif items_1[1] < items_2[1]:
                    return -1
                else:
                    return 1
                
                
            elif not d1 and d2 :  #first letter second digit
                return -1
                
            else:
                return 1
      
        logs.sort(key= cmp_to_key(compare))
        return logs