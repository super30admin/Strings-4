#  Time Complexity : O(m + n)   m is the number of rows and n is the number of columns
#  Space Complexity : O(1)  
#  Did this code successfully run on Leetcode : Yes
#  Three line explanation of solution in plain english: This code simulates a “hotter/colder” search on a 2D grid to find a hidden target at a fixed location (targetRow = 4, targetCol = 2) using Manhattan distance as feedback. The findObject method starts at the top-left corner and moves down rows while the response is HOTTER, then resets and moves across columns in the same way, using getResponse to determine whether each move is getting closer to or farther from the target. The getResponse function compares the previous cell’s distance to the target with the current cell’s distance and returns HOTTER, COLDER, SAME, or EXACT, updating the previous position after each check

from enum import Enum

class Response(Enum):
    HOTTER = 1
    COLDER = 2
    SAME = 3
    EXACT = 4

class GFG:
    def __init__(self):
        self.prevRow = -1
        self.prevCol = -1
        self.targetRow = 4
        self.targetCol = 2
    #In this function we start from the top left and move towards the bottom right. Starting from the top left corner we check for the response using the getResponse function. If we find the object needed then we return the location. If not we move to the next row and check if we are going nearer or further off the target location. Then we reset the previous row and column to -1 and start from the first column. We again give a call to the getResponse function based on the new row and column. If it is a exact match then we return the target location if not then we move the column ahead by 1 and check if we are going near to or away from the target location.   
    def findObject(self, grid):
        m = len(grid)
        n = len(grid[0])

        row = 0
        col = 0

        res = self.getResponse(row, col)
        if res == Response.EXACT:
            return [row, col]
        
        while row + 1 < m:
            res = self.getResponse(row + 1, col)
            if res == Response.EXACT:
                return [row + 1, col]
            
            if res == Response.HOTTER:
                row = row + 1
            else:
                break
        
        self.prevRow = -1
        self.prevCol = -1

        col = 0

        while col + 1 < n:
            res = self.getResponse(row, col + 1)
            if res == Response.EXACT:
                return [row, col + 1]
            
            if res == Response.HOTTER:
                col = col + 1
            else:
                break
        
        return [row, col]

    # In this function we check if the row and column equal the target row and target column. If we are starting off from the top left and that is not the target in itself then we return the HOTTER response. But if we are not at the top left cell then we calculate the dist of the prev cell from the target cell and the new cell from the target cell. Based on the distance found we return the required response. Then we set both the previous column and previous row to the new column and row.  
    def getResponse(self, row, col):
        if row == self.targetRow and col == self.targetCol:
            return Response.EXACT
        
        if self.prevRow == -1 and self.prevCol == -1:
            self.prevRow = row
            self.prevCol = col
            return Response.HOTTER
        
        prevDist = abs(self.prevRow - self.targetRow) + abs(self.prevCol - self.targetCol)
        newDist = abs(row - self.prevRow) + abs(col - self.prevCol)

        if newDist == 0:
            res = Response.EXACT
        elif newDist > prevDist:
            res = Response.COLDER
        elif newDist < prevDist:
            res = Response.HOTTER
        else:
            res = Response.SAME
        
        self.prevRow = row
        self.prevCol = col

        return res

if __name__ == "__main__":
    finder = GFG()
    grid = [
        ['o', 'o', 'o'],
        ['o', 'o', 'o'],
        ['o', 'o', 'o'],
        ['o', 'o', 'o'],
        ['o', 'o', 'x']
    ]
    ans = finder.findObject(grid)
    print(f"Object found at: [{ans[0]}, {ans[1]}]")
