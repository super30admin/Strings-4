from enum import Enum

class Response(Enum):
    HOTTER = 1
    COLDER = 2
    SAME = 3
    EXACT = 4
    
class GridSearch:
    def __init__(self,grid):
        self.grid = grid
        self.prev = None
        self.target = None
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 'x':
                    self.target = (i,j)
    
    def distance(self,r,c):
        return abs(r-self.target[0]) + abs(c-self.target[1])

    def getResponse(self,r,c):
        if (r,c) == self.target:
            return Response.EXACT
        if not self.prev:
            self.prev = (r,c)
            return Response.HOTTER
        prevdist = self.distance(*self.prev)
        newdist = self.distance(r,c)
        self.prev = (r,c)
        if newdist<prevdist:
            return Response.HOTTER
        elif newdist>prevdist:
            return Response.COLDER
        else:
            return Response.SAME
    
    def optimizedSearch(self):
        row,col = len(self.grid), len(self.grid[0])
        low,high = 0, row-1
        bestrow = None
        while low<=high:
            mid = low + high-low//2
            res = self.getResponse(mid,0)
            if res == Response.EXACT: return [mid,0]
            elif res == Response.HOTTER :
                high = mid-1
                bestrow = mid
            else:
                low = mid+1
                bestrow = low
        if not bestrow:
            bestrow = low
        l,h=0,col-1
        while l<=h:
            m = l + h-l//2
            r = self.getResponse(bestrow,m)
            if r == Response.EXACT: return [bestrow,m]
            elif r == Response.HOTTER :
                h = m-1
            else:
                l = m+1
        return None
        
    

grid = [['o','o','o'],['o','x','o'],['o','o','o']]
searcher = GridSearch(grid)
print("Optimized Binary Search:", searcher.optimizedSearch())