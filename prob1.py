# Time Complexity : O(logn)
# Space Complexity :O(1)
# Passed on Leetcode: yes

class ObjectFinder:
    def __init__(self, grid):
        self.grid = grid
        self.rows = len(grid)
        self.cols = len(grid[0])
        self.object_row = None
        self.object_col = None

    def searchForObject(self):
        left, right = 0, self.cols * self.rows - 1
        
        while left <= right:
            mid = (left + right) // 2
            row, col = divmod(mid, self.cols)
            response = self.getResponse(row, col)
            
            if response == 'EXACT':
                return [row, col]
            elif response == 'HOTTER':
                left = mid + 1
            elif response == 'COLDER' or response == 'SAME':
                right = mid - 1
        
        return None

    def getResponse(self, row, col):
        if row < 0 or col < 0 or row >= self.rows or col >= self.cols:
            raise ValueError("Row or col is out of bounds.")
        
        if self.object_row is None or self.object_col is None:
            if self.grid[row][col] == 'x':
                self.object_row = row
                self.object_col = col
                return 'EXACT'
            else:
                return 'HOTTER'
        
        distance_to_object = abs(row - self.object_row) + abs(col - self.object_col)
        previous_distance = abs(self.object_row - self.object_row) + abs(self.object_col - self.object_col)
        
        if distance_to_object < previous_distance:
            return 'HOTTER'
        elif distance_to_object > previous_distance:
            return 'COLDER'
        else:
            return 'SAME'
