// Time Complexity : O(log m  + log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
We perform binary search firstly on the columns to decide which column might have the object by comparing
the response API result and trying to adjust low, high values accordingly.If the response is HOTTER, we move
more close by updating low value, if COLDER, then decrement high value.Now, using the obtained col value,
we perform binary search on rows to identify which row might contain the target object using the similar
approach. Lastly, we return the array of row and column which contains the target object.
 */
import java.util.*;

enum Response {
    HOTTER, COLDER, SAME, EXACT;
}

public class GFG {

    private int prevRow = -1;
    private int prevCol = -1;

    private final int targetRow = 4;
    private final int targetCol = 2;

    public static void main(String[] args) {
        GFG finder = new GFG();
        int[][] grid = {
                {'o', 'o', 'o'},
                {'o', 'o', 'o'},
                {'o', 'o', 'o'},
                {'o', 'o', 'o'},
                {'o', 'o', 'x'}
        };

        int[] ans = finder.findObject(grid);
        System.out.println("Object found at: [" + ans[0] + ", " + ans[1] + "]");
    }

    public int[] findObject(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        prevRow = -1;
        prevCol = -1;

        int col = binarySearchColumn(0, cols);

        prevRow = -1;
        prevCol = -1;

        int row = binarySearchRow(rows, col);

        return new int[]{row, col};
    }

    private int binarySearchColumn(int fixedRow, int cols) {
        int low = 0, high = cols - 1;

        while(low < high) {
            int mid = low + (high - low) / 2;

            //check for mid
            Response midResp = getResponse(fixedRow, mid);
            if(midResp == Response.EXACT)
                return mid;

            //check for mid+1 wrt mid
            Response rightResp = getResponse(fixedRow, mid + 1);
            if(rightResp == Response.EXACT)
                return mid + 1;

            if(rightResp == Response.HOTTER)
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }

    private int binarySearchRow(int rows, int fixedCol) {
        int low = 0 , high = rows - 1;

        while(low < high) {
            int mid = low + (high - low) / 2;
            Response midResp = getResponse(mid, fixedCol);
            if(midResp == Response.EXACT)
                return mid;

            //check for mid+1 wrt mid
            Response downResp = getResponse(mid + 1, fixedCol);
            if(downResp == Response.EXACT)
                return mid + 1;

            if(downResp == Response.HOTTER)
                low = mid + 1;
            else
                high = mid;

        }
        return low;
    }

    public Response getResponse(int r, int c) {
        if (r == targetRow && c == targetCol) {
            return Response.EXACT;
        }

        if (prevRow == -1 && prevCol == -1) {
            prevRow = r;
            prevCol = c;
            return Response.HOTTER;
        }

        int prevDist = Math.abs(prevRow - targetRow) + Math.abs(prevCol - targetCol);
        int newDist = Math.abs(r - targetRow) + Math.abs(c - targetCol);

        Response res;
        if (newDist == 0) {
            res = Response.EXACT;
        } else if (newDist < prevDist) {
            res = Response.HOTTER;
        } else if (newDist > prevDist) {
            res = Response.COLDER;
        } else {
            res = Response.SAME;
        }

        prevRow = r;
        prevCol = c;

        return res;
    }
}
