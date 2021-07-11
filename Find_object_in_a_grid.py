def colsearch(grid):
    low = 0
    high = len(grid[0])
    
    while low<=high:
        mid = low + (high - low)//2
        
        if getresponse(mid+1) == "Hotter":
            low = mid+1
        elif getresponse(mid-1) == "Hotter":
            high = mid-1
        else:
            return mid

def rowsearch(grid):
    
    low = 0
    high = len(grid)
    while low <= high:
        mid = low + (high - low) //2
        if getresponse(mid+1) == "Hotter":
            low = mid+1
        elif getresponse(mid-1) == "Hotter":
            high = mid-1
        else:
            return mid
        
def getresponse()
    
    

def main():
    
    row = rowsearch(grid)
    col = columnsearch(grid)
    
    return grid[row][col]


if __name__ == '__main__':
    main()


