#Time: O(logn)
#Space: O(1)

from enum import Enum, auto


class Response(Enum):
    HOTTER = auto()
    COLDER = auto()
    SAME = auto()
    EXACT = auto()

class Solution:
    def __init__(self, grid):
        self.grid = grid
        self.m, self.n = len(grid), len(grid[0]) 
        self.cur_x, self.cur_y = -1, -1
        self.x_left_bound, self.x_right_bound = 0, self.m - 1
        self.y_left_bound, self.y_right_bound = 0, self.n - 1

    def get_response(grid, row, col):
        pass
    
    def column_bsearch(grid, start, end):
        while self.y_left_bound <= self.y_right_bound:
            mid = (start + end) // 2
            self.cur_x,  self.cur_y = 0, mid
            if get_response(grid, 0, mid) == Response.EXACT or (self.get_response(grid, 0 , mid + 1) != Response.HOTTER and self.get_response(grid, 0, mid - 1) != Response.HOTTER):
                return mid
            elif get_response(grid, 0, mid + 1) == Response.HOTTER:
                self.y_left_bound = mid + 1
            else:
                self.y_right_bound = mid - 1
                
    def row_bsearch(grid, start, end):
        while self.x_left_bound <= self.x_right_bound:
            mid = (start + end) // 2
            self.cur_x,  self.cur_y = mid, 0
            if get_response(grid, mid, 0) == Response.EXACT or (self.get_response(grid, mid + 1, 0) != Response.HOTTER and self.get_response(grid, mid - 1, 0) != Response.HOTTER):
                return mid
            elif get_response(grid, mid + 1, 0) == Response.HOTTER:
                self.x_left_bound = mid + 1
            else:
                self.x_right_bound = mid - 1

    def find_object(grid):
        closest_x_pos = row_bsearch(0, m - 1)
        closest_y_pos = column_bsearch(0, n - 1)
        return [closest_x_pos, closest_y_pos]