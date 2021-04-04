
class Solution:
    def reorderLogFiles(self, logs: List[str]) -> List[str]:
        string = []
        digit = []
        for l in logs:
            if l.split()[1].isdigit():
                digit.append(l)
            else:
                string.append(l)
        string= sorted(string, key=lambda x: x.split()[0])
        string= sorted(string, key=lambda x: x.split()[1:])
        result=string+digit
        return result
            