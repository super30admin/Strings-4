import java.util.Arrays;
/*
Reorder Data in Log Files
approach: implement custom comparator
time: O(m * n log n) n - number of logs, m - avg length of each log
space: O(2 m)
 */
public class Problem3 {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (a,b) -> {
            String[] aStrings = a.split(" ", 2);
            String[] bStrings = b.split(" ", 2);
            boolean isDigit1 = Character.isDigit(aStrings[1].charAt(0));
            boolean isDigit2 = Character.isDigit(bStrings[1].charAt(0));

            if (!isDigit1 && !isDigit2) {
                //both letter logs, so compare based on lexographical order
                int comp = aStrings[1].compareTo(bStrings[1]);
                if (comp != 0) {
                    return comp;
                }
                else {
                    // sort based on order of identifier
                    return aStrings[0].compareTo(bStrings[0]);
                }
            } else if (isDigit1 && !isDigit2) {
                return 1;
            } else if (!isDigit1 && isDigit2) {
                return -1;
            }
            else {
                //both are digit logs
                return 0;
            }
        });

        return logs;
    }
}
