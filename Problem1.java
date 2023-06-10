/*
Find object in a grid
approach:
we can do a binary search on row and on column.
for finding on which row object lies, we check for grid[low][0] which is first call, and it is hotter, now calculate
mid and call getResponse api which will give hotter or colder based on previous position which is grid[low][0].
now, if mid is hotter, then we move our low to mid+1. we repeat this until loop breaks and return low which is our target row.
do this for column as well which gives us the target column.
time: O(log m + log n)
space: O(1)
 */
/*
public class Problem1 {
    public int[] findObjectInGrid() {
        int n = maxBound(true),
                m = maxBound(false);
        int objectRow = findRowOrColumn(true, 0, n - 1);
        int objectColumn = findRowOrColumn(false, 0, m - 1);
        return new int[] {objectRow, objectRow};
    }

    private int maxBound(boolean isRow) {
        int low = 0,
                high = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = low + (high - low)/2;
            Response r = getResponse(isRow ? mid : 0, isRow ? 0 : mid);
            if (r.isError()) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private Response getResponse(int i, int i1) {
        return new Response().getResponse(i, i1);
    }

    private int findRowOrColumn(boolean isRow, int start, int end) {
        int low = start,
                high = end;
        while (low <= high) {
            Response r1 = getResponse(isRow ? low : 0, isRow ? 0 : low);
            Response r2 = getResponse(isRow ? high : 0, isRow ? 0 : high);
            int mid = low + (high - low)/2;
            switch (r2.code()) {
                case EXACT:
                    return high;
                case SAME:
                    return mid;
                case HOTTER:
                    low = mid;
                    break;
                case COLDER:
                    high = mid;
                    break;
            }
        }
        return -1;
    }
}

 */
