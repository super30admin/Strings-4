class Solution:
    def reorderLogFiles(self, logs: List[str]) -> List[str]:
        from functools import cmp_to_key 
        def sort1(l1, l2):
            log1 = l1.split(' ', 1)
            log2 = l2.split(' ', 1)

            is_digit_l1 = log1[1][0].isdigit()
            is_digit_l2 = log2[1][0].isdigit()

            if (not is_digit_l1) and (not is_digit_l2):
                if log1[1] == log2[1]:
                    if log1[0] < log2[0]:
                        return -1
                    else:
                        return 1
                elif log1[1] < log2[1]:
                    return -1 
                else:
                    return 1
                 
            elif (not is_digit_l1) and is_digit_l2:
                return -1
            elif is_digit_l1 and (not is_digit_l2):
                return 1
            else:
                return 0
        
        x = sorted(logs, key= cmp_to_key(sort1))
        return x