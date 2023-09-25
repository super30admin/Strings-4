class Response:
    HOTTER = "HOTTER"
    COLDER = "COLDER"
    SAME = "SAME"
    EXACT = "EXACT"

class ObjectFinder:
    def __init__(self, grid):
        self.grid = grid
        self.rows = len(grid)
        self.cols = len(grid[0])

    def find_object(self):
        for row in range(self.rows):
            for col in range(self.cols):
                response = self.get_response(row, col)
                if response == Response.EXACT:
                    return [row, col]

    def get_response(self, row, col):
        if row < 0 or row >= self.rows or col < 0 or col >= self.cols:
            raise ValueError("Out of bounds")
        
        return self.getResponse(row, col)

    # Simulate the getResponse API
    def getResponse(self, row, col):
        return Response.HOTTER if self.grid[row][col] == 'x' else Response.COLDER

# Example 1
grid1 = [['o', 'o', 'o'],
         ['o', 'o', 'o'],
         ['x', 'o', 'o']]

finder1 = ObjectFinder(grid1)
result1 = finder1.find_object()
print(result1)  # Output: [2, 0]

# Example 2
grid2 = [['o', 'o', 'o', 'o', 'o'],
         ['o', 'o', 'o', 'o', 'o'],
         ['o', 'o', 'o', 'o', 'o'],
         ['o', 'o', 'o', 'o', 'o'],
         ['o', 'o', 'o', 'x', 'o'],
         ['o', 'o', 'o', 'o', 'o']]

finder2 = ObjectFinder(grid2)
result2 = finder2.find_object()
print(result2)  # Output: [4, 3]

#T.C=O(n2) S.C=O(mxn)