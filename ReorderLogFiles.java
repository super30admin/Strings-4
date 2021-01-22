package S30.Strings_4;


/*
Time Complexity : O(nlogn)
Space Complexity : O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/


import java.util.Arrays;
import java.util.Comparator;

public class ReorderLogFiles {

    public String[] reorderLogFiles(String[] logs) {
        //Letter-logs come before digit-logs;
        //Letter-logs are sorted alphanumerically, by content then identifier;
        //Digit-logs remain in the same order.


        Arrays.sort(logs, new Comparator<String>(){

            @Override
            public int compare(String log1, String log2){

                String[] split1 = log1.split(" ",2);
                String[] split2 = log2.split(" ",2);

                Boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
                Boolean isDigit2 = Character.isDigit(split2[1].charAt(0));

                if(isDigit1 && isDigit2){ // both are digit logs - maintain original order
                    return 0;
                }

                if(!isDigit1 && !isDigit2){ // both are letter logs

                    String letter1 = split1[1];
                    String letter2 = split2[1];
                    int cmp = letter1.compareTo(letter2);
                    if(cmp != 0){
                        return cmp;
                    }
                    return split1[0].compareTo(split2[0]);

                }

                if(isDigit1) return 1;
                return -1;

            }

        });

        return logs;
    }
}
