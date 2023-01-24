package s30.strings.s4;

import java.util.Arrays;
import java.util.Collections;

public class ReorderDatainLogFiles {


    public String[] reorderLogFiles(String[] logs) {


        Arrays.sort(logs, (a, b) -> {

            int aCode = getCode(a);
            int bCode = getCode(b);

            int diff = aCode - bCode;

            if(diff == 0 && aCode == 0){

                String aContent = getContent(a);
                String bContent = getContent(b);

                diff = aContent.compareTo(bContent);

                if(diff == 0){

                    String aId = getId(a);
                    String bId = getId(b);

                    diff = aId.compareTo(bId);
                }

            }


            return diff;


        });


        return logs;

    }



    private String getContent(String log){


        //iterate till first white space
        int index = log.indexOf(" ");
        index++;

        return log.substring(index);

    }

    private String getId(String log){
        int index = log.indexOf(" ");

        return log.substring(0, index);
    }

    private int getCode(String log){

        int n = log.length();

        if(Character.isDigit(log.charAt(n-1)))  return 1;


        return 0;
    }
    public static void main(String[] args) {
    int[] arr = {2,4,6,1,0,-2,-15};


    }
}
