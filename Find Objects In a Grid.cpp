// Time Complexity: O(n), where n is the number of cells in the grid.
// Space Complexity: O(1), as we are using a constant amount of extra space.
// This code is designed to find an object in a grid using a response system.

// Approach:
// 1. Start at the center of the grid.
// 2. Use a response system to determine if the current position is the object.
// 3. If not, check adjacent cells in a specific order (right, down, left, up).


#include <vector>
#include <utility>
using namespace std;
enum Response {
    EXACT, // Found the object
    HOTTER, // The object is closer than before
    COLDER // The object is farther than before
};
Response getResponse(int r, int c) {
    // This function is a placeholder for the actual implementation
    // that would interact with the environment to get the response.
    // In a real scenario, this would be replaced with the actual logic.
    return EXACT; // For demonstration purposes, always return EXACT
}
pair<int, int> findObject(int rows, int cols) {
    int r = rows / 2;
    int c = cols / 2;
    int prevR = r, prevC = c;

    Response res = getResponse(r, c);
    if (res == EXACT) return {r, c};

    vector<pair<int, int>> dirs = {{0,1},{1,0},{0,-1},{-1,0}}; // R, D, L, U

    while (true) {
        pair<int, int> bestMove = {r, c};
        for (auto [dr, dc] : dirs) {
            int nr = r + dr, nc = c + dc;
            if (nr < 0 || nc < 0 || nr >= rows || nc >= cols) continue;
            Response newRes = getResponse(nr, nc);
            if (newRes == EXACT) return {nr, nc};
            if (newRes == HOTTER) {
                prevR = r; prevC = c;
                r = nr; c = nc;
                break;
            }
        }
    }
}
