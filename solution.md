# Problem 1: String to Integer (atoi)
## Time Complexity :
O(n)

## Space Complexity :
O(1)

## Did this code successfully run on Leetcode :
No.
## Any problem you faced while coding this :
Yes. Cannot figure out what am I missing out.
## Your code here along with comments explaining your approach
### Solution:
      class Solution:
          def myAtoi(self, string: str) -> int:
              if not string or len(string)==0:
                  return 0
              result=0
              isNegative = False

              string=string.strip()
              if len(string)==0:
                  return 0
              cursor=0
              if string[0]=='+' or string[0]=='-':
                  if string[0]=='-':
                      isNegative=True
                  cursor+=1
              for cursor in range(len(string)):
                  ch=string[cursor]
                  if ch<'0' or ch>'9':
                      break
                  else:
                      result=result*10+(ord(ch)-ord('0'))
              if isNegative:
                  result*=-1
              if result>float('inf'):
                  return float('inf')
              if result<float('-inf'):
                  return float('-inf')
              return result
              
# Problem 2: Reorder Data in Log Files
## Time Complexity :
O(nlogn)

## Space Complexity :
O(1)

## Did this code successfully run on Leetcode :
Yes.

## Any problem you faced while coding this :
No.

## Your code here along with comments explaining your approach
### Solution:
    class Solution:
        def reorderLogFiles(self, logs: List[str]) -> List[str]:
            def key(log):
                identifier, content = log.split(" ", 1)
                # if letter
                if content[0].isalpha():
                    return 0, content, identifier
                # if digit
                else:
                    return 1,

            return sorted(logs, key=key)
