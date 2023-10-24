import java.util.Arrays;

// Time Complexity : O(n log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

public class ReorderLogFiles {
    public String[] reorderLogFiles(String[] logs) {

        Arrays.sort(logs,(String a, String b)->{

            String[] splitArr1 = a.split(" ",2);
            String[] splitArr2 = b.split(" ",2);

            boolean isDigit1 = Character.isDigit(splitArr1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(splitArr2[1].charAt(0));

            if(!isDigit1 && !isDigit2){

                int comp = splitArr1[1].compareTo(splitArr2[1]);
                if(comp == 0){
                    return splitArr1[0].compareTo(splitArr2[0]);
                }
                return comp;

            }else if(!isDigit1 && isDigit2){
                return -1;
            }else if(isDigit1 && !isDigit2){
                return 1;
            }else{
                return 0;
            }

        });

        return logs;
    }
}
