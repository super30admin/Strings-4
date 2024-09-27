import java.util.Arrays;

public class ReorderLogs {
    // Sorting strings
    // TC : O(N) N= n * k where, n - number of elements in logs array, k - average length of the string
    // SC : O(1)
    public String[] reorderLogFiles(String[] logs) {
        if(logs == null || logs.length == 0) return new String[]{};

        Arrays.sort(logs, (log1, log2) -> {
            String[] strArray1 = log1.split(" ",2);
            String[] strArray2 = log2.split(" ",2);

            boolean isDigit1 = Character.isDigit(log1.charAt(log1.length() - 1));
            boolean isDigit2 = Character.isDigit(log2.charAt(log2.length() - 1));

            if(!isDigit1 && !isDigit2){ // both are letter logs
                int cmp = strArray1[1].compareTo(strArray2[1]);
                if(cmp == 0){
                    return strArray1[0].compareTo(strArray2[0]);
                }
                return cmp;
            }else if(isDigit1 && !isDigit2){ // first one is digit log. So, it is kinda greater than second object
                return 1;
            }else if(!isDigit1) {
                return -1;
            }else
                return 0;
        });

        return logs;
    }
}
