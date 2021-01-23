class Solution:
    def reorderLogFiles(self, logs: List[str]) -> List[str]:
        
        
        def getOrder(log):
            identifier, remaining = log.split(" ", maxsplit=1)
            return (0, remaining, identifier) if remaining[0].isalpha() else (1,None)
        return sorted(logs, key = getOrder)
TIme: N+M logN
Space: MN
