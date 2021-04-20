#Time Complexity:O(nlogn)
#Space Complexity:O(n)
#Approach:for every string in the logs array , we check the second element of string. if the element is a number we add the string to the 
#numbers array ,else to the letters array. We then sort the letters array  according to the second word and return the concatination of both the arrays
class Solution:
    def reorderLogFiles(self, logs: List[str]) -> List[str]:
        letters=[]
        numbers=[]
        for log in logs:
            if log.split()[1].isdigit():
                numbers.append(log)
            else:
                letters.append(log)
        letters.sort(key=lambda log:(log.split()[1:],log.split()[0]))
        return letters+numbers