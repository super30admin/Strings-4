// Time Complexity : O(n logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

import java.util.Arrays;

public class ReorderDataInLogs {

    public String[] reorderLogFiles(String[] logs) {

        Arrays.sort(logs, (a, b) -> {
            String[] splitArr1 = a.split(" ", 2);
            String[] splitArr2 = b.split(" ", 2);

            //check if its digit log based on 1st char in 2nd split arr
            boolean digit1 = Character.isDigit(splitArr1[1].charAt(0));
            boolean digit2 = Character.isDigit(splitArr2[1].charAt(0));

            //case 1: both are letter logs
            if(!digit1 && !digit2){
                //compare 2nd split
                int comparision = splitArr1[1].compareTo(splitArr2[1]);
                // 1 0 -1
                if(comparision == 0){
                    //both logs have same content
                    return splitArr1[0].compareTo(splitArr2[0]);
                }
                return comparision;

            }else if(digit1 && !digit2){
                //case 2: 1 digit and 1 letter log
                return 1;
            }else if(!digit1 && digit2){
                //case 2: 1 digit and 1 letter log
                return -1;
            }else{
                //case 3: both are digit logs
                return 0;
            }
        });
        return logs;
    }
}
