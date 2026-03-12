# Time Complexity : O(M*N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Logical Implementation
# Any problem you faced while coding this : API simulation assumption

# Explanation:
# Start from (0,0) and move across grid positions.
# Track response changes (HOTTER/COLDER).
# When EXACT is returned we found the object.

def findObject(rows, cols):
    
    prev_row, prev_col = 0, 0
    
    for r in range(rows):
        for c in range(cols):
            
            response = getResponse(r, c)
            
            if response == Response.EXACT:
                return [r, c]
    
    return [-1, -1]