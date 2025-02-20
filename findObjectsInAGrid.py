# Time:O(mlogn) 
# Space:O(1)
# Leetcode: N/A
# Issues:


# enum Response {
# 	HOTTER,  // Moving closer to target
# 	COLDER,  // Moving farther from target
# 	SAME,    // Same distance from the target as your previous guess
# 	EXACT;   // Reached destination
# }

# // Throws an error if 'row' or 'col' is out of bounds
# public Response getResponse(int row, int col) {
# 	// black box
# }
# Example 1:


# Input:
# [['o', 'o', 'o'],
#  ['o', 'o', 'o'],
#  ['x', 'o', 'o']]

# Output: [2, 0]
# Example 2:


# Input:
# [['o', 'o', 'o', 'o', 'o'],
#  ['o', 'o', 'o', 'o', 'o'],
#  ['o', 'o', 'o', 'o', 'o'],
#  ['o', 'o', 'o', 'o', 'o'],
#  ['o', 'o', 'o', 'x', 'o'],
#  ['o', 'o', 'o', 'o', 'o']]

# Output: [4, 3]

# we need r,c of current grid
# r,c of target
# we can perform 
# 1) Binary search
# 2) row traversal then column tarversal

class Guesser:  
    def __init__(self, rows, columns):
        self.rows = rows
        self.columns = columns
        
    def get_response(self, row, col):
        if not 0 <= row < self.rows and 0 <= col < self.columns:
            raise ValueError("R or C out of bounds.")
            
    # logic