//problem1
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

        // Reset oracle before column search
        prevRow = -1;
        prevCol = -1;
        int col = binarySearchColumn(0, cols);

        // Reset oracle before row search
        prevRow = -1;
        prevCol = -1;
        int row = binarySearchRow(col, rows);

        return new int[]{row, col};
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

    private int binarySearchColumn(int fixedRow, int n) {
        int low = 0, high = n - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            Response midRes = getResponse(fixedRow, mid);
            if (midRes == Response.EXACT) return mid;

            Response rightRes = getResponse(fixedRow, mid + 1);
            if (rightRes == Response.EXACT) return mid + 1;

            if (rightRes == Response.HOTTER) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    private int binarySearchRow(int fixedCol, int m) {
        int low = 0, high = m - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            Response midRes = getResponse(mid, fixedCol);
            if (midRes == Response.EXACT) return mid;

            Response downRes = getResponse(mid + 1, fixedCol);
            if (downRes == Response.EXACT) return mid + 1;

            if (downRes == Response.HOTTER) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }
}
//problem2
class Solution {
    public int myAtoi(String s) {

        s = s.trim();

        if(s.length() == 0) return 0;
        char c = s.charAt(0);
        if(!Character.isDigit(c) && c != '+' && c != '-') return 0;
        boolean flag = true;

        if(c == '-'){
            flag = false;
        }

        long result = 0;
       
        for(int i=0; i<s.length(); i++){ 
            c = s.charAt(i);

            if(Character.isDigit(c)){
                result = result * 10 + c - '0';

                if(result > Integer.MAX_VALUE){
                    if(flag) return Integer.MAX_VALUE;
                    else return Integer.MIN_VALUE;
                }
            }else{
                if(i != 0) break;
            }
        }

        if(flag) return (int)result;
        else return -(int)result;
    }
}

//problem3
class Solution {
    public String[] reorderLogFiles(String[] logs) {
        List<String> digit=new ArrayList<>();
        List<String> letter=new ArrayList<>();
        for(String log:logs){
            String[] splitarr=log.split(" ",2);
            if(Character.isDigit(splitarr[1].charAt(0))){
                digit.add(log);
            }else{
                letter.add(log);
            }
        }
        Collections.sort(letter,(a,b)->{
            String[] splitarr1=a.split(" ",2);
            String[] splitarr2=b.split(" ",2);
            int cmp=splitarr1[1].compareTo(splitarr2[1]);
            if(cmp==0){
                return splitarr1[0].compareTo(splitarr2[0]);
            }
            return cmp;
        });
        int i=0;
        for(String le:letter){
            logs[i++]=le;
        }
        for(String di:digit){
            logs[i++]=di;
        }
        return logs;
    }
}
