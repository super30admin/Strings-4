// let1 art can
// In this let1 is - identifier
// art can is -  log
//String[] splitArr1 = log1.split(" ", 2);       => split[0] = let1,       split[1] = art can is

//TC:O(MNlogN) , N-> no. of logs, M: avg length of log -> for toCompare() function
//SC:O(MlogN)
//Did it run successfully on Leetcode?:Yes
class Solution {
    public String[] reorderLogFiles(String[] logs) {
      if ( logs == null || logs.length == 0)
          return null;
       Arrays.sort(logs, (log1, log2) -> {
           
           String[] splitArr1 = log1.split(" ", 2);
           String[] splitArr2 = log2.split(" ", 2);
           
           boolean isDigit1 = Character.isDigit(splitArr1[1].charAt(0));
           boolean isDigit2 = Character.isDigit(splitArr2[1].charAt(0));
           
           if (!isDigit1 && !isDigit2){ //means they are letter logs
               int comp = splitArr1[1].compareTo(splitArr2[1]);
               if (comp == 0) {
                   return splitArr1[0].compareTo(splitArr2[0]);
               }
               return comp;
           } 
           else if (!isDigit1 && isDigit2) {  //isDigit1 is letter log, so return -1 (1st element)
               return -1;
           }
           else if (isDigit1 && !isDigit2){  //isDigit2 is letter log, so return 1 (2nd element)
               return 1;
           }
           else {
               return 0;
           }    
       });
       return logs;
    }
}
