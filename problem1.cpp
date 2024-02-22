#include <iostream>
#include <vector>

using namespace std;

enum Response { HOTTER, COLDER, SAME, EXACT };

class Solution {
public:
    Solution() : row(-1), col(-1) {}
    int n;
    int m;
    vector<int> findObject(vector<vector<char>>& grid) {
        n = grid.size();
        m = grid[0].size();
        
        // Traverse the grid to find the object
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grid[i][j] == 'x') {
                    row = i;
                    col = j;
                    break;
                }
            }
        }
        
        // Binary search to find the row and column of the object
        int lowRow = 0, highRow = n - 1;
        int lowCol = 0, highCol = m - 1;
        
        while (lowRow <= highRow || lowCol <= highCol) {
            int midRow = lowRow + (highRow - lowRow) / 2;
            int midCol = lowCol + (highCol - lowCol) / 2;
            
            Response response = getResponse(midRow, midCol);
            
            if (response == EXACT) {
                return {midRow, midCol};
            } else if (response == HOTTER) {
                lowRow = max(0, midRow - 1);
                highRow = min(n - 1, midRow + 1);
                lowCol = max(0, midCol - 1);
                highCol = min(m - 1, midCol + 1);
            } else if (response == COLDER || response == SAME) {
                if (midRow == lowRow && midCol == lowCol) {
                    lowRow++;
                    lowCol++;
                } else if (midRow == highRow && midCol == highCol) {
                    highRow--;
                    highCol--;
                } else if (midRow == lowRow && midCol == highCol) {
                    lowRow++;
                    highCol--;
                } else if (midRow == highRow && midCol == lowCol) {
                    highRow--;
                    lowCol++;
                } else if (midRow == lowRow) {
                    lowCol = midCol;
                    highCol = midCol;
                } else if (midRow == highRow) {
                    lowCol = midCol;
                    highCol = midCol;
                } else if (midCol == lowCol) {
                    lowRow = midRow;
                    highRow = midRow;
                } else if (midCol == highCol) {
                    lowRow = midRow;
                    highRow = midRow;
                } else if (midRow < row) {
                    lowRow = midRow;
                } else if (midRow > row) {
                    highRow = midRow;
                } else if (midCol < col) {
                    lowCol = midCol;
                } else if (midCol > col) {
                    highCol = midCol;
                }
            }
        }
        
        return {-1, -1}; // Object not found
    }
    
    Response getResponse(int row, int col) {
        if (row < 0 || row >= n || col < 0 || col >= m)
            throw out_of_range("Out of bounds");
        
        if (row == this->row && col == this->col)
            return EXACT;
        
        int distance = abs(this->row - row) + abs(this->col - col);
        int prevDistance = abs(this->row - prevRow) + abs(this->col - prevCol);
        
        if (distance < prevDistance)
            return HOTTER;
        else if (distance > prevDistance)
            return COLDER;
        else
            return SAME;
    }
    
private:
    int row, col;
    int prevRow, prevCol;
};

int main() {
    Solution solution;

    vector<vector<char>> grid1 = {
        {'o', 'o', 'o'},
        {'o', 'o', 'o'},
        {'x', 'o', 'o'}
    };
    vector<int> result1 = solution.findObject(grid1);
    cout << "Object found at: [" << result1[0] << ", " << result1[1] << "]" << endl;

    vector<vector<char>> grid2 = {
        {'o', 'o', 'o', 'o', 'o'},
        {'o', 'o', 'o', 'o', 'o'},
        {'o', 'o', 'o', 'o', 'o'},
        {'o', 'o', 'o', 'o', 'o'},
        {'o', 'o', 'o', 'x', 'o'},
        {'o', 'o', 'o', 'o', 'o'}
    };
    vector<int> result2 = solution.findObject(grid2);
    cout << "Object found at: [" << result2[0] << ", " << result2[1] << "]" << endl;

    return 0;
}
