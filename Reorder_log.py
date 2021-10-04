#Space:O(Mlogn)
#time:(MNlogN)
class Solution:
    def reorderLogFiles(self, logs: List[str]) -> List[str]:
        def compare(item1, item2):
            
            item1_split = item1.split( " " )
            item2_split = item2.split( " " )
            
            if item1_split[1].isdigit() and item2_split[1].isdigit():
                return 0
            
            elif item1_split[1].isdigit() and not item2_split[1].isdigit():
                return 1
            
            elif not item1_split[1].isdigit() and item2_split[1].isdigit():
                return -1
            
            else:
                item1_log = item1_split[1:]
                item2_log = item2_split[1:]
                if item1_log<item2_log:
                    return -1
                elif item1_log>item2_log:
                    return 1
                else:
                    if item1_split[0]<item2_split[0]:
                        return -1
                    elif item1_split[0]>item2_split[0]:
                        return 1
                    else:
                        return 0
        # Calling
        logs = sorted(logs,key=cmp_to_key(compare))
        return logs